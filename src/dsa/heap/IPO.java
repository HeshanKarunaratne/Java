package dsa.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Heshan Karunaratne
 */
public class IPO {

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> minC = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Queue<Integer> maxP = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < profits.length; i++) {
            minC.add(new int[]{capital[i], profits[i]});
        }

        while (k-- > 0) {
            while (!minC.isEmpty() && minC.peek()[0] <= w) {
                maxP.add(minC.poll()[1]);
            }
            if (maxP.isEmpty()) break;
            w += maxP.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};
        int maximizedCapital = findMaximizedCapital(k, w, profits, capital);
        System.out.println(maximizedCapital);
    }
}
