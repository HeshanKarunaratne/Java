package dsa.oned_dp;

/*
322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0
 */

/**
 * @author Heshan Karunaratne
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 9};
        int amount = 11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return 0;

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

}

/*
We can create a separate array starting from 0 till n where we measure how many coins that are needed to create the given number from the given list of coins

Example:
Amount = 11
Coins = [1,5,6,9]

amount    | 0 | 1   | 2   | 3   | 4   | 5   | 6   | 7       | 8       | 9   | 10      | 11      |
min coins | 0 | 1x1 | 1x2 | 1x3 | 1x4 | 5*1 | 6*1 | 6*1+1*1 | 6*1+1*2 | 9*1 | 9x1+1x1 | 5x1+6x1 |
coin count| 0 | 1   | 2   | 3   | 4   | 1   | 1   | 2       | 3       | 1   | 2       | 2       |

Logic is the selected coin should be equal or less than the number and (minCoinsDP[i - coin]) should not be the MAX_VALUE
Then we need to update the minimum coins we need for each selected coin

Time Complexity: O(mxn) : where m is the total number of coins and n is the number you have to make
Space Complexity: O(n) : Need an array of size n to store the results
 */