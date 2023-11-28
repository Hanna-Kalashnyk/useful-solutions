package leetcode.demo.problems;

import java.util.Arrays;

public class LongestUnrepetableString {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) return n;
        int left = 0;
        int max = 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        for (int end = 0; end < n; end++) {
            int endChar = s.charAt(end);
            if (map[endChar] > -1) {
                left = Math.max(left, map[endChar] + 1);
            }
            map[endChar] = end;
            max = Math.max(max, end - left + 1);
        }
        return Math.max(max, n - left);
    }
}