package SolidPrinciples;

/**
 * @author Heshan Karunaratne
 */
public class NoShape implements NoAreaShape {

    @Override
    public double volume() {
        return 100.0;
    }
}
