package dsa.oned_dp;

/*
70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

/**
 * @author Heshan Karunaratne
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n == 1) return 1;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) arr[i] = arr[i - 1] + arr[i - 2];

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}

/*
At any time the number of stairs to climb will be derived using below
steps[n] = steps[n-1] + steps[n-2]

You can reach level n using -> (1 step from n-1) and (2 steps from n-2)

Time Complexity: O(n) -> we are iterating the whole list 1 time
Space Complexity: O(n) -> We are using an extra dynamic programming array to keep track of the previous value
 */