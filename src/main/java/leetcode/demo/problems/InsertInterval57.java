package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
 * intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 */
public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] < newInterval[0]) {
                ans.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
