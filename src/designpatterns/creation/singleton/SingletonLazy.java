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

