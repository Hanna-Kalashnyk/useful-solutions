package leetcode.demo.problems;

import java.util.TreeMap;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 */
public class MeetingroomII253 {
    public int roomNumber(int[][] meetings) {
        TreeMap<Integer, Integer> heap = new TreeMap<>();
        for (int[] interval : meetings) {
            heap.put(interval[0], heap.getOrDefault(interval[0], 0) + 1);
            heap.put(interval[1], heap.getOrDefault(interval[1], 0) -1);
        }
        int cur = 0;
        int res = 0;
        for (Integer value : heap.values()) {
            cur +=  value;
            res = Math.max(cur, res);
        }
        return res;
    }
}
