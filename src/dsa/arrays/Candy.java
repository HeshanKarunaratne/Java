package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class Candy {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2};
        System.out.println(candy(arr));
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        if (ratings == null || n == 0) return 0;

        int candyCount = 0;

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] >= ratings[i]) left[i] = 1;
            else left[i] = left[i - 1] + 1;
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] <= ratings[i + 1]) right[i] = 1;
            else right[i] = right[i + 1] + 1;
        }

        for (int i = 0; i < n; i++) {
            candyCount += Math.max(left[i], right[i]);
        }
        return candyCount;
    }
}
