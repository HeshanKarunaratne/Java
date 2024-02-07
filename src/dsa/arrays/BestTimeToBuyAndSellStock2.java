package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class BestTimeToBuyAndSellStock2 {


    public static void main(String[] args) {

//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {7, 6, 5, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        if (prices.length < 2) return 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }
}
