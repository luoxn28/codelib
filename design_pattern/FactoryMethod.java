/**
 * 工厂方法
 */
public class FactoryMethod {

    public static void main(String[] args) {
        ProductFactory productAFactory = new ProductAFactory();
        ProductFactory productBFactory = new ProductBFactory();

        Product pa = productAFactory.create();
        Product pb = productBFactory.create();

        System.out.println(pa.getClass().getSimpleName());
        System.out.println(pb.getClass().getSimpleName());
    }

    interface Product { }
    static class ProductA implements Product { }
    static class ProductB implements Product { }

    interface ProductFactory {
        Product create();
    }
    static class ProductAFactory implements ProductFactory {
        @Override
        public Product create() {
            return new ProductA();
        }
    }
    static class ProductBFactory implements ProductFactory {
        @Override
        public Product create() {
            return new ProductB();
        }
    }
}


