package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class ArrayManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long[] answer = new long[n + 2];
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < queries.size(); i++) {
            int a = queries.get(i).get(0);
            int b = queries.get(i).get(1);
            int k = queries.get(i).get(2);
            answer[a - 1] += k;
            answer[b] -= k;
        }
        long currLong = 0L;
        for (int i = 0; i < answer.length; i++) {
            currLong += answer[i];
            maxSum = Math.max(currLong, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int n =5;

        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1,2,100));
        list.add(List.of(2,5,100));
        list.add(List.of(3,4,100));
        System.out.println(arrayManipulation(5, list));
    }
}
