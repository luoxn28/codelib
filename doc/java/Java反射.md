通过反射设置类/对象属性示例：[JavaReflectionUpdateFieldDemo.java](https://github.com/luoxn28/codelib/blob/master/src/java/main/com/github/luo/reflection/JavaReflectionUpdateFieldDemo.java)，不过针对`final static`属性，直接使用`Field.set`会报异常，可通过以下代码更改反射modifier权限进行更改：

```java
Field fssField = ReflectionUtils.findField(JavaReflectionUpdateFieldDemo.class, "fss");
// 修改modifier权限
Field modifiers = ReflectionUtils.findField(fssField.getClass(), "modifiers");
modifiers.setAccessible(true);
modifiers.setInt(fssField, fssField.getModifiers() & ~Modifier.FINAL);
```



