package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class NumberOfGoodPairs {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(arr));
    }

    public static int numIdenticalPairs(int[] nums) {

        int[] freq = new int[102];

        for (int i : nums) {
            freq[i]++;
        }

        int total = 0;

        for (int i : freq) {
            total += (i * (i - 1)) / 2;
        }

        return total;
    }
}
