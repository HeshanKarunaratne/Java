SOLID PRINCIPLES

1) Single Responsibility Principle
    
    Each class should have only one sole purpose

2) Open Closed Principle
    
    Classes should be open for extension and closed for modification. 
    In other words you should not have to rewrite an existing class for implementing new features.
    
3) Liskov Substitution Principle

    That every subclass or derived class should be substitutable for their base or parent class.
    
4) Interface Segregation Principle

    Interfaces should not force classes to implement what they can't do. Large interfaces should be divided into small ones.

5) Dependency Inversion Principle

    Components should depend on abstractions, not on concretions.

Below Code snippets are before applying SOLID principles

Circle.java
~~~java
public class Circle {

    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
~~~

Square.java
~~~java
public class Square {
    private final int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
~~~

AreaCalculator.java
~~~java
public class AreaCalculator {
    public int sum(List<Object> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++) {
            Object shape = shapes.get(i);
            if (shape instanceof Square) {
                sum += Math.pow(((Square) shape).getLength(), 2);
            }
            if (shape instanceof Circle) {
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            }
        }
        return sum;
    }
}
~~~

Main.java
~~~java
public class Main {
    public static void main(String[] args) {

        AreaCalculator areaCalculator = new AreaCalculator();
        Circle circle = new Circle(10);
        Square square = new Square(10);

        List<Object> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(square);

        int sum = areaCalculator.sum(shapes);
        System.out.println("sum = " + sum);
        
    }
}
~~~

Single Responsibility: We need to create a dedicated class to print out the sum(Do not add print methods inside AreaCalculator.java class)

~~~java
public class ShapesPrinter {
    public String json(int sum) {
        return String.format("{ shapesSum: %s}", sum);
    }

    public String csv(int sum) {
        return String.format("shapesSum,%s", sum);
    }
}
~~~

Open Close Principle

~~~java
public interface Shape {
    double area();
}
~~~

Square.java
~~~java
public class Square implements Shape {
    private final int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public double area() {
        return Math.pow(getLength(), 2);
    }
}
~~~

Circle.java
~~~java
public class Circle implements Shape {

    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}
~~~

AreaCalculator.java
~~~java
public class AreaCalculator {
    public int sum(List<Shape> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++) {
            sum += shapes.get(i).area();
        }
        return sum;
    }
}
~~~

Liscov Substitution Principle: Circle,Square should be identified as Shapes where as NoShape is identified as a NoAreaShape which doesn't have an area. Instead of Circle and Square we can use Shape as well.

NoAreaShape.java
~~~java
public interface NoAreaShape {
    double volume();
}
~~~

NoShape.java
~~~java
public class NoShape implements NoAreaShape {

    @Override
    public double volume() {
        return 100.0;
    }
}
~~~