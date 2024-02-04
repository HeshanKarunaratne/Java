package dsa.intervals;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
//        int arr[][] = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int arr[][] = {{1, 6}, {2, 8}, {7, 12}, {10, 16},};
        int arr[][] = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
//        int arr[][] = {{1, 2}, {2, 3}, {3, 4}, {4, 5},};
        System.out.println(findMinArrowShots(arr));
    }

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n < 2) return n;

        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrow = 1;
        int preEndPoint = points[0][1];

        for (int i = 1; i < n; i++) {
            if (points[i][0] <= preEndPoint && preEndPoint <= points[i][1]) {
                continue;
            } else {
                arrow++;
                preEndPoint = points[i][1];
            }
        }
        return arrow;
    }

}
