package leetcode.demo.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * METal assessment:
 * Find the closest element in List to the Target. If there are two elements on the same diff - chose the smallest.
 */
public class ClosestElemInList {
    public int findClosest(List<Integer> ar, int target) {
        // Collections.sort(ar);
        ar.sort(null);  //Time complexity is O(n log n)
        int low = 0;
        int high = ar.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (ar.get(mid) == target) return target;
            if (ar.get(mid) < target) low = mid + 1;
            if (ar.get(mid) > target) high = mid;
        }
        if (high == 0) return ar.get(0);
        if (Math.abs(ar.get(high) - target) == Math.abs(ar.get(high - 1) - target)) return ar.get(high - 1);
        return Math.abs(ar.get(high) - target) > Math.abs(ar.get(high - 1) - target) ? ar.get(high - 1) : ar.get(high);
    }

    public int findClosestOn(List<Integer> ar, int target) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < ar.size(); i++) {
            int diff = Math.abs(target - ar.get(i));
            if (diff < min) {
                min = diff;
                res = ar.get(i);
            }

            if (diff == min) {
                res = Math.min(res, ar.get(i));
            }
        }
        return res;
    }
}
