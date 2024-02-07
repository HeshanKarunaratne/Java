package dsa.arrays;

import java.util.Arrays;

/**
 * @author Heshan Karunaratne
 */
public class HIndex {

    public static void main(String[] args) {
//        int arr[] = {3, 0, 6, 1, 5};
        int arr[] = {1, 3, 1};
        System.out.println(hIndex(arr));
        System.out.println(hIndexV2(arr));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int idx = 0;
        while (idx < n && n - idx > citations[idx]) {
            idx++;
        }

        return n - idx;
    }

    public static int hIndexV2(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {

            int val = citations[i];
            if (val > n) {
                arr[n]++;
            } else {
                arr[val]++;
            }
        }

        int n1 = arr.length - 1;
        int sum = 0;
        for (int i = n1; i >= 0; i--) {
            sum += arr[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

}
