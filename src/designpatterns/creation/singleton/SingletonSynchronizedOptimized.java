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