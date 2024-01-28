package dsa.two_pointers;

/**
 * @author Heshan Karunaratne
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        if (height.length <= 1) {
            return 0;
        }

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (leftPointer < rightPointer) {

            int minValue = Math.min(height[leftPointer], height[rightPointer]);
            int area = (rightPointer - leftPointer) * minValue;
            maxArea = Math.max(maxArea, area);

            if (height[leftPointer] < height[rightPointer]) leftPointer++;
            else rightPointer--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
