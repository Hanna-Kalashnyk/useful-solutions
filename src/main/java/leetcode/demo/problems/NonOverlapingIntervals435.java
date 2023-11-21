package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class NonOverlapingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n  = intervals.length;
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        list.sort(Comparator.comparingInt(interval -> interval.endTime));

        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(Integer.MIN_VALUE, 0);
        for (Interval l : list) {
            int prev = queue.floorEntry(l.startTime).getValue();
            int cur = prev + 1;
            int last = queue.lastEntry().getValue();
            if (cur > last) queue.put(l.endTime, cur);
        }

    return n - queue.lastEntry().getValue();
    }
    public record Interval(int startTime, int endTime) {};
}
