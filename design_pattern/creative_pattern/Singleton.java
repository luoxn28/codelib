package creative_pattern;

/**
 * 单例模式，本质上单例模式有2种：
 *   饥汉模式：getInstance前已经创建完毕
 *   懒汉模式：getInstance时再创建
 */
public class Singleton {

    public static void main(String[] args) {

    }

    private Singleton() {
    }

    // 饥汉模式
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }

    // 懒汉模式
    private static volatile Singleton instance2;
    public static Singleton getInstance2() {
        if (instance2 == null) {
            synchronized (Singleton.class) {
                if (instance2 == null) {
                    instance2 = new Singleton();
                }
            }
        }
        return instance2;
    }
}
