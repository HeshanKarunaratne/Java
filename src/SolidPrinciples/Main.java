package SolidPrinciples;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class Main {
    public static void main(String[] args) {

        AreaCalculator areaCalculator = new AreaCalculator();
        Circle circle = new Circle(10);
        Square square = new Square(10);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(square);

        int sum = areaCalculator.sum(shapes);
        ShapesPrinter shapesPrinter = new ShapesPrinter();
        System.out.println(shapesPrinter.json(sum));
        System.out.println(shapesPrinter.csv(sum));

    }
}
