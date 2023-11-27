package leetcode.demo.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {

        int length = s.length();
        if (s.isEmpty())
            return 0;
        if (length == 0 || length == 1)
            return length;
        s = s.replaceAll("\\s+", " ");

        Map<Character, Integer> chars = new HashMap<>();
        char[] charsArray = s.toCharArray();
        int maxUnrepited = 0;
        int result = 0;

        int leftSide = 0;
        if (charsArray.length < 0 || charsArray.length > 50000) {
            System.out.println("nums.length is OUT of restricted values");
        }

        for (int i = 0; i < charsArray.length; i++) {
            if (!chars.containsKey(charsArray[i])) {
                chars.put(charsArray[i], i);
                maxUnrepited = i - leftSide + 1;
            } else {
                leftSide = leftSide > (chars.get(charsArray[i])) ? leftSide : (chars.get(charsArray[i]) + 1);
                chars.put(charsArray[i], i);
                maxUnrepited = (i - leftSide + 1) > maxUnrepited ? (i - leftSide + 1) : maxUnrepited;
            }
            result = result >= maxUnrepited ? result : maxUnrepited;

        }
        return result = result >= maxUnrepited ? result : maxUnrepited;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        if (n < 2) return n;
        int left = 0;
        int res = 0;
        int[] present = new int[128];
        Arrays.fill(present, -1);
        for (int i = 0; i < n; i++) {
            if (present[s.charAt(i)] > -1) {
                left = Math.max(left, present[s.charAt(i)] + 1);
                res = Math.max(res, i - left + 1);
                present[s.charAt(i)] = i;
            } else {
                present[s.charAt(i)] = i;
                res = Math.max(res, i - left + 1);
            }
        }
        return Math.max(res, n - left);
    }
}