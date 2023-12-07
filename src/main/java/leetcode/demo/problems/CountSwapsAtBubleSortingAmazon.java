package leetcode.demo.problems;

/**
 * You're a new Amazon Software Development Engineer (SDE). You're reading through your team's code
 * and find an old sorting algorithm. The following algorithm is used to sort an array of distinct n integers:
 * For the input array arr of size n do:
 *  Try to find the smallest pair of indices 0 ≤ i < j ≤ n-1 such that arr[i] > arr[j].
 * Here smallest means usual alphabetical ordering of pairs, i.e. (i1, j1) < (i2, j2) if and only if i1 < i2 or (i1 = i2 and j1 < j2).
 *  If there is no such pair, stop.
 *  Otherwise, swap a[i] and a[j] and repeat finding the next pair.
 * 7
 * Amazon Confidential
 * The algorithm seems to be correct, but the question is how efficient is it?
 * Write a function that returns the number of swaps performed by the above algorithm.
 */
public class CountSwapsAtBubleSortingAmazon {
    public int swapCount(int[] arr) {
        int n = arr.length;
        int start = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                    count++;
                }
            }
        }
            return count;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
