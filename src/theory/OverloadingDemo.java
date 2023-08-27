package theory;

/**
 * @author Heshan Karunaratne
 */
public class OverloadingDemo {
    public static void main(String[] args) {
        print(10);
    }

    public static void print(String a) {
        System.out.println("print String");
    }
    
    public static void print(int a) {
        System.out.println("print int");
    }

    public static void print(double a) {
        System.out.println("print double");
    }

    public static void print(short a) {
        System.out.println("print short");
    }
}
