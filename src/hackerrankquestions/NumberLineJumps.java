package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class NumberLineJumps {

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        if (v1 <= v2) return "NO";
        int remainder = (x2 - x1) % (v1 - v2);
        return remainder == 0 ? "YES" : "NO";

    }

    public static void main(String[] args) {
        System.out.println(kangaroo(43, 2, 70, 2));
    }
}
