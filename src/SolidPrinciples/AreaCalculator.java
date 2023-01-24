package SolidPrinciples;

import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class AreaCalculator {
    public int sum(List<Shape> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++) {
            sum += shapes.get(i).area();
        }
        return sum;
    }
}
