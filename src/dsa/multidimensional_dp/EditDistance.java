package dsa.multidimensional_dp;

/**
 * @author Heshan Karunaratne
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] costDp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) costDp[i][0] = i;
        for (int j = 1; j <= n; j++) costDp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    costDp[i][j] = costDp[i - 1][j - 1];
                } else {
                    int topLeft = costDp[i - 1][j - 1];
                    int top = costDp[i - 1][j];
                    int left = costDp[i][j - 1];
                    costDp[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
                }
            }
        }
        return costDp[m][n];
    }

    public static void main(String[] args) {
        int i = minDistance("horse", "ros");
        System.out.println(i);
    }
}
