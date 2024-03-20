package dsa.oned_dp;

/**
 * @author Heshan Karunaratne
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {

        if (amount == 0 || coins == null || coins.length == 0) return 0;

        int[] minCoinsDP = new int[amount + 1];
        minCoinsDP[0] = 0;

        for (int i = 1; i < minCoinsDP.length; i++) {
            minCoinsDP[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
                }
            }
        }

        if (minCoinsDP[amount] == Integer.MAX_VALUE) return -1;
        return minCoinsDP[amount];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }
}
