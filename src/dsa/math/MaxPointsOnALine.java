package dsa.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Heshan Karunaratne
 */
public class MaxPointsOnALine {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {

        int n = points.length;
        if (n < 2) return n;

        Set<String> set = new HashSet<>();
        int max = 1;

        for (int i = 0; i < n && !set.contains(points[i][0] + "-" + points[i][1]); i++) {
            int[] a = points[i];
            int same = 0;
            int localMax = 1;
            Map<Double, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                if (isSame(a, points[j])) {
                    same++;
                    continue;
                }

                double slope = getSlope(a, points[j]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }

            set.add(a[0] + "-" + a[1]);
            max = Math.max(max, localMax + same);

        }
        return max;
    }

    private static boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private static double getSlope(int[] a, int[] b) {
        if (a[0] == b[0]) return Double.MAX_VALUE;
        if (a[1] == b[1]) return 0;
        return (double) (a[1] - b[1]) / (double) (a[0] - b[0]);
    }
}

