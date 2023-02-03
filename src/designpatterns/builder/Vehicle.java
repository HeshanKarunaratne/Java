package designpatterns.builder;

/**
 * @author Heshan Karunaratne
 */
public class Vehicle {
    //required
    private String engine;
    private int wheel;

    //optional
    private int airbags;
    private boolean hasHelmet;

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }

    public boolean isHasHelmet() {
        return hasHelmet;
    }

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
        this.hasHelmet = builder.hasHelmet;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbags;
        private boolean hasHelmet;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public VehicleBuilder setHasHelmet(boolean hasHelmet) {
            this.hasHelmet = hasHelmet;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

class BuilderPatternTest {
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).setHasHelmet(true).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());
        System.out.println(car.isHasHelmet());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
        System.out.println(bike.isHasHelmet());
    }
}