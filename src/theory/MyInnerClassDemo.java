package theory;

/**
 * @author Heshan Karunaratne
 */
public class MyInnerClassDemo {
    private String name;
    private int age;

    public MyInnerClassDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println(this.name + ": " + this.age);
    }

    static class Test {
        public static void main(String[] args) {
            MyInnerClassDemo myInnerClassDemo = new MyInnerClassDemo("heshan", 10);
            myInnerClassDemo.print();
        }

    }
}

class Test {
    public static void main(String[] args) {
        MyInnerClassDemo myInnerClassDemo = new MyInnerClassDemo("heshan", 12);
        myInnerClassDemo.print();

    }
}
