package SolidPrinciples;

/**
 * @author Heshan Karunaratne
 */
public class ShapesPrinter {
    public String json(int sum) {
        return String.format("{ shapesSum: %s}", sum);
    }

    public String csv(int sum) {
        return String.format("shapesSum,%s", sum);
    }
}
