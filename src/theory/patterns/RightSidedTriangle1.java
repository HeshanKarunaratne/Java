package theory.patterns;

/**
 * @author Heshan Karunaratne
 */
public class RightSidedTriangle1 {
    public static void main(String[] args) {
        final int SIZE = 5;
        for (int i = 1; i <= SIZE; i++) {
            for (int j = i; j <= SIZE - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
