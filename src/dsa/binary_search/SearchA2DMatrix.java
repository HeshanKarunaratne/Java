package dsa.binary_search;

/**
 * @author Heshan Karunaratne
 */
public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowId = checkForPotentialRow(matrix, target);
        if (rowId != -1) return binarySearchOverRow(matrix, target, rowId);
        return false;
    }

    private static boolean binarySearchOverRow(int[][] matrix, int target, int rowId) {
        int start = 0, end = matrix[rowId].length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[rowId][mid] == target) return true;
            if (matrix[rowId][mid] > target) end = mid - 1;
            if (matrix[rowId][mid] < target) start = mid + 1;
        }
        return false;
    }

    private static int checkForPotentialRow(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) return mid;
            if (matrix[mid][0] > target) end = mid - 1;
            if (matrix[mid][0] < target) start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean b = searchMatrix(matrix, 12);
        System.out.println(b);
    }
}
