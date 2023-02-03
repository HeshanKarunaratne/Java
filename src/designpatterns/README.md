Creation Design Patterns
- Singleton Pattern
- Factory Pattern
- Builder Pattern
- Prototype Pattern

Singleton Design Pattern
- Only one instance of the class should exist
- Constructor should be private
- Public method for returning instance

Initialization Types
- Eager 
- Lazy
- Thread safe Method
- Thread safe Block

~~~java
package designpatterns.singleton;

/**
 * @author Heshan Karunaratne
 */
public class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}

class Test {
    
    public static void main(String[] args) {
        SingletonEager singletonEager = SingletonEager.getInstance();
        System.out.println(singletonEager);

        SingletonEager singletonEager1 = SingletonEager.getInstance();
        System.out.println(singletonEager1);
    }
}
~~~

~~~java
package designpatterns.singleton;

/**
 * @author Heshan Karunaratne
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null)
            instance = new SingletonLazy();

        return instance;
    }
}

class Test2 {

    public static void main(String[] args) {
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1);

        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singletonLazy2);
    }
}
~~~

~~~java
package designpatterns.singleton;

/**
 * @author Heshan Karunaratne
 */
public class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
    }

    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null)
            instance = new SingletonSynchronized();

        return instance;
    }
}

class Test3 {

    public static void main(String[] args) {
        SingletonSynchronized singletonSynchronized1 = SingletonSynchronized.getInstance();
        System.out.println(singletonSynchronized1);

        SingletonSynchronized singletonSynchronized2 = SingletonSynchronized.getInstance();
        System.out.println(singletonSynchronized2);
    }
}
~~~

~~~java
package designpatterns.singleton;

/**
 * @author Heshan Karunaratne
 */
public class SingletonSynchronizedOptimized {
    private static SingletonSynchronizedOptimized instance;

    private SingletonSynchronizedOptimized() {
    }

    public static SingletonSynchronizedOptimized getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronizedOptimized.class) {
                instance = new SingletonSynchronizedOptimized();
            }
        }
        return instance;
    }
}

class Test4 {

    public static void main(String[] args) {
        SingletonSynchronizedOptimized singletonSynchronizedOptimized1 = SingletonSynchronizedOptimized.getInstance();
        System.out.println(singletonSynchronizedOptimized1);

        SingletonSynchronizedOptimized singletonSynchronizedOptimized2 = SingletonSynchronizedOptimized.getInstance();
        System.out.println(singletonSynchronizedOptimized2);
    }
}
~~~

Factory Design Pattern
- Used when we have multiple subclasses of a super class and based on input we want to return one class instance
- Provides abstraction between implementation and client classes

~~~java
package designpatterns.factory;

/**
 * @author Heshan Karunaratne
 */
abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends Vehicle {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {
    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if (type == "car") {
            return new Car(wheel);
        } else if (type == "bike") {
            return new Bike(wheel);
        }
        return null;
    }
}

class FactoryPatternMain {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }
}
~~~

Builder Design Pattern
- Used when we have too many arguments to send in Constructor & it's hard to maintain the order
- When we don't want to send all parameters in Object initialization

~~~java
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
~~~

Prototype Pattern
- Used when you want to avoid multiple Object creation of same instance, instead you copy the object to new object and then we can modify as per our need

~~~java
package designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<>();
        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }
        return new Vehicle(tempList);
    }
}

class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze");

        System.out.println(a.getVehicleList());
        System.out.println(list);

        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
    }
}
~~~