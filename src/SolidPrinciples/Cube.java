package SolidPrinciples;

/**
 * @author Heshan Karunaratne
 */
public class Cube implements Shape, ThreeDimensionalShape {
    @Override
    public double area() {
        return 100;
    }

    @Override
    public double volume() {
        return 200;
    }
}
