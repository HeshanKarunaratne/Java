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