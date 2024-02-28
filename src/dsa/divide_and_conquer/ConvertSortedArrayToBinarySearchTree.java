package dsa.divide_and_conquer;

/**
 * @author Heshan Karunaratne
 */
public class ConvertSortedArrayToBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) return null;

        int start = 0;
        int end = nums.length - 1;
        return sortedArrayToBST(nums, start, end);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        if (start > end) return null;

        int midIndex = (start + end) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBST(nums, start, midIndex - 1);
        root.right = sortedArrayToBST(nums, midIndex + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode output = sortedArrayToBST(nums);
        System.out.println(output);
    }


}
