package dsa.heap;

import java.util.PriorityQueue;

/**
 * @author Heshan Karunaratne
 */
public class KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static int findKthLargestQuickSelect(int[] arr, int k) {
        int left = 0, right = arr.length - 1, kth;
        while (true) {
            int idx = partition(arr, left, right);
            if (idx == k - 1) {
                kth = arr[idx];
                break;
            }
            if (idx < k - 1) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
        return kth;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left] ;
        int l = left + 1 ;
        int r = right;
        while (l <= r) {
            if (arr[l] < pivot && arr[r] > pivot) {
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++ ;
                r-- ;
            }
            if (arr[l] >= pivot) {
                l++;
            }
            if (arr[r] <= pivot) {
                r--;
            }
        }
        int temp2=arr[left];
        arr[left]=arr[r];
        arr[r]=temp2;
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);

        int kthLargestQuickSelect = findKthLargestQuickSelect(nums, 2);
        System.out.println(kthLargestQuickSelect);
    }
}
