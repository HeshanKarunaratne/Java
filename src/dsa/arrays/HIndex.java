package dsa.arrays;

/*
274. H-Index

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

Example 1:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

Example 2:
Input: citations = [1,3,1]
Output: 1

 */

/**
 * @author Heshan Karunaratne
 */
public class HIndex {

    public static void main(String[] args) {
        int arr[] = {3, 0, 6, 1, 5};
        System.out.println(hIndex(arr));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int c : citations) {
            if (c >= n) buckets[n]++;
            else buckets[c]++;
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) return i;
        }
        return 0;
    }
}

/*
There are 5 elements in the array. We need to create a bucket sort with 6 buckets(0, 5) and if the element is greater than n we will add it to nth bucket otherwise to its respectful bucket and need to increment each occurrence

bucket  | 0 | 1 | 2 | 3 | 4 | 5
count   | 1 | 1 | 0 | 1 | 0 | 2

We need to iterate from backwards (because we need to find the highest H-index) to a point where the below condition meets.

count += buckets[i];
if (count >= i) return i;

 */
