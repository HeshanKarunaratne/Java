Creation Design Patterns
- Singleton Pattern


Singleton Pattern
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