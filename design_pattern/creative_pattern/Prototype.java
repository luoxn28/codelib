package creative_pattern;

/**
 * 原型模式 根据已存在的对象创建一个新的对象
 */
public class Prototype implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();

        System.out.println(prototype);
        System.out.println(prototype.clone());
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
