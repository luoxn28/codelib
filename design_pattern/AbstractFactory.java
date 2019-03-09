/**
 * 抽象工厂
 */
public class AbstractFactory {

    public static void main(String[] args) {
        ProductCarFactory productCarAFactory = new ProductCarAFactory();
        ProductCarFactory productCarBFactory = new ProductCarBFactory();

        Product pa = productCarAFactory.createProduct();
        Car ca = productCarAFactory.createCar();

        Product pb = productCarBFactory.createProduct();
        Car cb = productCarBFactory.createCar();

        System.out.println(pa.getClass().getSimpleName());
        System.out.println(ca.getClass().getSimpleName());
        System.out.println(pb.getClass().getSimpleName());
        System.out.println(cb.getClass().getSimpleName());
    }

    interface Product { }
    static class ProductA implements Product { }
    static class ProductB implements Product { }

    interface Car {}
    static class CarA implements Car { }
    static class CarB implements  Car { }

    interface ProductCarFactory {
        Product createProduct();
        Car createCar();
    }
    static class ProductCarAFactory implements ProductCarFactory {
        @Override
        public Product createProduct() {
            return new ProductA();
        }
        @Override
        public Car createCar() {
            return new CarA();
        }
    }
    static class ProductCarBFactory implements ProductCarFactory {
        @Override
        public Product createProduct() {
            return new ProductB();
        }
        @Override
        public Car createCar() {
            return new CarB();
        }
    }
}
