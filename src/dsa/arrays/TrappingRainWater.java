package dsa.arrays;

/**
 * @author Heshan Karunaratne
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {

        if (height.length < 2) return 0;
        int waterSize = 0;
        int n = height.length;

        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            if (height[i] <= left[i - 1])
                left[i] = left[i - 1];
            else
                left[i] = height[i];
        }

        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] <= right[i + 1])
                right[i] = right[i + 1];
            else
                right[i] = height[i];
        }

        for (int i = 0; i < n; i++)
            waterSize += (Math.min(left[i], right[i]) - height[i]);

        return waterSize;
    }
}
