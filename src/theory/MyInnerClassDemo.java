package theory;

/**
 * @author Heshan Karunaratne
 */
public class MyInnerClassDemo {
    public static void main(String[] args) {

        B b = new B(){
            @Override
            public void show() {
                System.out.println("OVERIDDEN");
            }
        };
        b.show();
    }
}
class B {
    public void show() {
        System.out.println("SHOW");
    }
}
