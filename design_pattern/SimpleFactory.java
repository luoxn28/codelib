/**
 * 简单工厂模式
 *
 * 根据不同入参创建不同的产品实例
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Product pa = ProductFactory.create("a");
        Product pb = ProductFactory.create("b");

        System.out.println(pa.getClass().getSimpleName());
        System.out.println(pb.getClass().getSimpleName());
    }

    /**
     * 产品类
     */
    interface Product { }
    static class ProductA implements Product { }
    static class ProductB implements Product { }

    static class ProductFactory {
        public static Product create(String product) {
            switch (product) {
                case "a": {
                    return new ProductA();
                }
                case "b": {
                    return new ProductB();
                }
                default: {
                    return null;
                }
            }
        }
    }
}


