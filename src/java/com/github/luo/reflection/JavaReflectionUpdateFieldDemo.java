package com.github.luo.reflection;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

/**
 * 通过反射机制修改类或者对象属性示例
 *
 * @author luoxiangnan
 * @date 2019-11-09
 */
public class JavaReflectionUpdateFieldDemo {

    private final static String fss = "finalStaticString";
    private final String fs = "finalString";
    private static String ss = "staticString";
    private String s = "string";

    public static void main(String[] args) throws IllegalAccessException {

        Field sField = ReflectionUtils.findField(JavaReflectionUpdateFieldDemo.class, "s");
        Field ssField = ReflectionUtils.findField(JavaReflectionUpdateFieldDemo.class, "ss");
        Field fsField = ReflectionUtils.findField(JavaReflectionUpdateFieldDemo.class, "fs");
        Field fssField = ReflectionUtils.findField(JavaReflectionUpdateFieldDemo.class, "fss");
        Stream.of(sField, fsField, ssField, fssField).forEach(o -> o.setAccessible(true));

        JavaReflectionUpdateFieldDemo demo = new JavaReflectionUpdateFieldDemo();
        System.out.println(demo.s + " " + demo.ss + " "  + demo.fs + " " + demo.fss);

        ReflectionUtils.setField(sField, demo, "string2");
        ReflectionUtils.setField(ssField, demo, "staticString2");
        ReflectionUtils.setField(fsField, demo, "finalString2");
        // 直接使用反射执行下面一行代码会报错
//        ReflectionUtils.setField(fssField, demo, "finalStaticString2");

        System.out.println(demo.s + " " + demo.ss + " "  + demo.fs + " " + demo.fss);
        // 由于final变量在使用的地方会按照常亮处理，所以上面一行代码的 demo.fs 实际在编译完成之后就提换成了 "finalString"，所以要查看最新的 demo.fs值，可以通过反射获取。
        System.out.println(demo.s + " " + demo.ss + " "  + fsField.get(demo) + " " + demo.fss);

        Field modifiers = ReflectionUtils.findField(fssField.getClass(), "modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(fssField, fssField.getModifiers() & ~Modifier.FINAL);
        ReflectionUtils.setField(fssField, demo, "finalStaticString2");

        System.out.println(demo.s + " " + demo.ss + " "  + fsField.get(demo) + " " + fssField.get(demo));
    }
}
