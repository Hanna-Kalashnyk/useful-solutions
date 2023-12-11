package leetcode.demo.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 */
public class MeetingRooms253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[j]) {
                max++;
            } else {
                j++;
            }
        }
        return max;
    }
}
