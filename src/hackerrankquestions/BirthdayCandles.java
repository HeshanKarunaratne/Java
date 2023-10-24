package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class BirthdayCandles {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 2, 4, 2, 1, 3, 4, 4, 3, 2, 3, 2, 2, 4, 2, 1, 3, 4};
        System.out.println(count1(arr));
    }

    public static int count1(int[] arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (Integer integer : arr) {
            if (integer > max) {
                max = integer;
            }
        }

        for (Integer integer : arr) {
            if (integer == max) {
                count++;
            }
        }
        return count;
    }
}
