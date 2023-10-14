package hackerrankquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
public class LargestRectangle {

    public static long largestRectangle(List<Integer> h) {
        if (h == null || h.size() == 0) {
            return 0;
        }

        int[] h1 = new int[h.size()];
        for (int i = 0; i < h.size(); i++) {
            h1[i] = h.get(i);
        }

        int n = h1.length;
        int[] left = new int[n];
        left[0] = -1;
        int[] right = new int[n];
        right[n - 1] = n;

        //Fill left array
        for (int i = 1; i < n; i++) {
            int prev = i - 1;
            while (prev >= 0 && h1[prev] >= h1[i]) {
                prev = left[prev];
            }
            left[i] = prev;
        }

        //Fill Right array
        for (int i = n - 2; i >= 0; i--) {
            int prev = i + 1;
            while (prev < n && h1[prev] >= h1[i]) {
                prev = right[prev];
            }
            right[i] = prev;
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, h1[i] * (right[i] - left[i] - 1));
        }
        return maxArea;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(3);
        System.out.println(largestRectangle(list));
    }
}
