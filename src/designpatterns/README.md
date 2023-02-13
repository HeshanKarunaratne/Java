Creation Design Patterns
- Singleton Pattern
- Factory Pattern
- Builder Pattern
- Prototype Pattern

Structural Design Patterns
- Proxy Pattern
- Facade Pattern
- Composite Pattern
- Decorator Pattern
- FlyWeight Pattern

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

Proxy Design Pattern
- Used to control access.

~~~java
package designpatterns.proxy;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public interface DatabaseExecutor {
    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecutorImpl implements DatabaseExecutor {
    public static final Logger LOGGER = Logger.getLogger(DatabaseExecutorImpl.class.getName());

    @Override
    public void executeDatabase(String query) {
        String value = "Going to execute Query: " + query;
        LOGGER.info(value);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor {
    public static final Logger LOGGER = Logger.getLogger(DatabaseExecutorProxy.class.getName());

    boolean ifAdmin;
    DatabaseExecutorImpl databaseExecutor;

    public DatabaseExecutorProxy(String name, String password) {
        if (name.equals("Admin") && password.equals("Admin@123")) {
            ifAdmin = true;
            databaseExecutor = new DatabaseExecutorImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        String value = "Going to execute Query: " + query;
        LOGGER.info(value);

        if (ifAdmin) {
            databaseExecutor.executeDatabase(query);
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non admin user");
            } else {
                databaseExecutor.executeDatabase(query);
            }
        }
    }
}

class ProxyTest {
    public static void main(String[] args) throws Exception {

        DatabaseExecutor nonAdminUser = new DatabaseExecutorProxy("NonAdmin", "NonAdmin@123");
        nonAdminUser.executeDatabase("DELETE");

        DatabaseExecutor adminUser = new DatabaseExecutorProxy("Admin", "Admin@123");
        adminUser.executeDatabase("DELETE");
        
    }
}
~~~

Facade Design Pattern

- Used when there're multiple interfaces of similar kind of jobs, then we can add a Facade interface, which provide better interface to these interfaces and clients.

~~~java
package designpatterns.facade;

import java.sql.Driver;

/**
 * @author Heshan Karunaratne
 */
class Firefox {
    public static Driver getFirefoxDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUnit Report for Firefox Driver");
    }
}

class Chrome {
    public static Driver getChromeDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUnit Report for Chrome Driver");
    }
}

class WebExplorerHelperFacade {
    public static void generateReports(String explorer, String report, String test) {
        Driver driver = null;
        switch (explorer) {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch (report) {
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (report) {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
                break;
        }
    }
}

class FacadePatternTest {
    public static void main(String[] args) {
        String test = "CheckElementPresent";
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
~~~

Composite Design Pattern

- Component: Account Class
- Leaf: DepositAccount & SavingsAccount
- Composite: CompositeAccount
- Client: Client Class

eg: We want to get the balance of all accounts for a person 

~~~java
package designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
abstract class Account {
    public abstract float getBalance();
}

class DepositAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public DepositAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class SavingsAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public SavingsAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() {
        totalBalance = 0;
        for (Account f : accountList) {
            totalBalance += f.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}

class Client {
    public static void main(String[] args) {
        CompositeAccount component = new CompositeAccount();

        component.addAccount(new DepositAccount("DA001", 100));
        component.addAccount(new DepositAccount("DA002", 230));
        component.addAccount(new SavingsAccount("SA001", 155));

        float totalBalance = component.getBalance();
        System.out.println("Total Balance: " + totalBalance);
    }
}
~~~

Decorator Design Pattern

- Used when we want to modify functionality of an Object at runtime & it should not change individual Object functionality

~~~java
package designpatterns.decorator;

/**
 * @author Heshan Karunaratne
 */
interface Dress {
    public void assemble();
}

class BasicDress implements Dress {

    @Override
    public void assemble() {
        System.out.println("Basic Dress features");
    }
}

class DressDecorator implements Dress {

    protected Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

class CasualDress extends DressDecorator {

    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress features");
    }
}

class SportyDress extends DressDecorator {

    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress features");
    }
}

class FancyDress extends DressDecorator {

    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress features");
    }
}

class DecoratorPatternTest {
    public static void main(String[] args) {
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
        System.out.println();

        Dress casualFancySportyDress = new CasualDress(new FancyDress(new SportyDress(new BasicDress())));
        casualFancySportyDress.assemble();
        System.out.println();
    }
}
~~~

FlyWeight Design Pattern

Used when we need to create many Objects of a class. We use it to reduce creation of Objects.

- Intrinsic properties: Which are same for an Object
- Extrinsic properties: Which are different for an Object

Ex:
- Interface: Employee
- Object: Developer, Tester
- Intrinsic properties: Fix the issue, Test the issue
- Extrinsic properties: Skills
- Factory: EmployeeFactory
- Client: Client Class

~~~java
package designpatterns.flyweight;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Heshan Karunaratne
 */
interface Employee {
    public void assignSkill(String skill);

    public void task();
}

class Developer implements Employee {
    private final String job;
    private String skill;

    public Developer() {
        job = "Fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with job: " + this.job);
    }
}

class Tester implements Employee {
    private final String job;
    private String skill;

    public Tester() {
        job = "Test the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with skill: " + this.skill + " with job: " + this.job);
    }
}

class EmployeeFactory {
    private static HashMap<String, Employee> m = new HashMap<>();

    public static Employee getEmployee(String type) {
        Employee p = null;
        if (m.get(type) != null) {
            p = m.get(type);
        } else {
            switch (type) {
                case "Developer":
                    System.out.println("Developer created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("no such employee");
            }
            m.put(type, p);
        }
        return p;
    }
}

class FlyweightTest {
    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", "Python", "React"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandomEmployee());
            e.assignSkill(getRandomSkill());
            e.task();
        }
    }

    private static String getRandomSkill() {
        return skills[new Random().nextInt(skills.length)];
    }

    private static String getRandomEmployee() {
        return employeeType[new Random().nextInt(employeeType.length)];
    }
}
~~~