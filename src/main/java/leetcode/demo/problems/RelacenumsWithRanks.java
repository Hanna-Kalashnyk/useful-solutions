package leetcode.demo.problems;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 */
public class RelacenumsWithRanks {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        // if (n < 2) return 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int count = 1;
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> el= map.firstEntry();
            map.remove(el.getKey());
            arr[el.getValue()] = count++;
        }
        return arr;
    }
}
