package theory.patterns;

/**
 * @author Heshan Karunaratne
 */
public class ReverseHillPattern {
    public static void main(String[] args) {
        final int SIZE = 5;
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j < SIZE; j++) {
                System.out.print("* ");
            }
            for (int j = i; j <= SIZE; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
