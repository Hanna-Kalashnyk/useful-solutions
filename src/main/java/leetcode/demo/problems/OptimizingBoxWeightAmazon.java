package leetcode.demo.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * An Amazon Fulfillment Associate has a set of items that need to be packed into two boxes.
 * Given an integer array of the item weights (arr) to be packed, divide the item weights into two subsets, A and B,
 * for packing into the associated boxes, while respecting the following conditions:
 *  The intersection of A and B is null.
 *  The union A and B is equal to the original array.
 *  The number of elements in subset A is minimal.
 *  The sum of A's weights is greater than the sum of B's weights.
 * Return the subset A in increasing order where the sum of A's weights is greater than the sum of B's weights.
 * If more than one subset A exists, return the one with the maximal total weight.
 */
public class OptimizingBoxWeightAmazon {
    public int[] minimalHeaviestSetA(int[] A){
        int sum = Arrays.stream(A).sum();
        int half = sum / 2;
        int big = 0;
        int start = 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 0; i--) {
            start++;
            big += A[i];
            if (big > half) break;
        }
        int[] res = Arrays.copyOfRange(A, A.length - start, A.length);
        return res;
    }
}
