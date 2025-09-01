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

class Test1 {

    public static void main(String[] args) {
        SingletonEager singletonEager = SingletonEager.getInstance();
        System.out.println(singletonEager);

        SingletonEager singletonEager1 = SingletonEager.getInstance();
        System.out.println(singletonEager1);
    }
}