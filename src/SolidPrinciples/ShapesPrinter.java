package SolidPrinciples;

import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class ShapesPrinter {
    private final IAreaCalculator iAreaCalculator;

    public ShapesPrinter(IAreaCalculator iAreaCalculator) {
        this.iAreaCalculator = iAreaCalculator;
    }

    public String json(List<Shape> shapes) {
        return String.format("{ shapesSum: %s}", iAreaCalculator.sum(shapes));
    }

    public String csv(List<Shape> shapes) {
        return String.format("shapesSum,%s", iAreaCalculator.sum(shapes));
    }
}
