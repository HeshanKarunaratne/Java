package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class BestTimeToBuyAndSellStock {


    public static void main(String[] args) {
        int[] prices = {7, 2, 5, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int buyPrice = 0;
        int profit = 0;

        buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            if (prices[i] > profit) {
                profit = prices[i] - buyPrice;
            }
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

}
