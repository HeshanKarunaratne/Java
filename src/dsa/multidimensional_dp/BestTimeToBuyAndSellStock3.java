package dsa.multidimensional_dp;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class BestTimeToBuyAndSellStock3 {

    public static int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getAns(prices, n, 0, 0, 2, dp);
    }

    static int getAns(int[] Arr, int n, int index, int buy, int cap, int[][][] dp) {

        if (index == n || cap == 0) return 0;
        if (dp[index][buy][cap] != -1) return dp[index][buy][cap];
        int profit = 0;

        if (buy == 0) {
            profit = Math.max(getAns(Arr, n, index + 1, 0, cap, dp),
                    -Arr[index] + getAns(Arr, n, index + 1, 1, cap, dp));
        }

        if (buy == 1) {
            profit = Math.max(getAns(Arr, n, index + 1, 1, cap, dp),
                    Arr[index] + getAns(Arr, n, index + 1, 0, cap - 1, dp));
        }

        return dp[index][buy][cap] = profit;
    }


    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
