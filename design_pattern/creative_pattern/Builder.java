package creative_pattern;

/**
 * 建造者模式 适合多入参类的新建操作
 */
public class Builder {

    public static void main(String[] args) {
        Builder builder = Builder.builder()
                .name("luoxn28")
                .age(23)
                .build();

        System.out.println(builder);
    }

    private String name;
    private int age;
    private String address;

    public Builder(BuilderWorker builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static BuilderWorker builder() {
        return new BuilderWorker();
    }

    static class BuilderWorker {
        private String name;
        private int age;
        private String address;

        public BuilderWorker name(String name) {
            this.name = name;
            return this;
        }
        public BuilderWorker age(int age) {
            this.age = age;
            return this;
        }
        public BuilderWorker address(String address) {
            this.address = address;
            return this;
        }

        public Builder build() {
            return new Builder(this);
        }
    }

    @Override
    public String toString() {
        return "Builder{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\''
                + '}';
    }
}
