package leetcode.demo.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 100184. Find Longest Special Substring That Occurs Thrice II
 * User Accepted:2693
 * User Tried:4779
 * Total Accepted:2819
 * Total Submissions:10879
 * Difficulty:Medium
 * You are given a string s that consists of lowercase English letters.
 * <p>
 * A string is called special if it is made up of only a single character. For example, the string "abc" is not special, whereas the strings "ddd", "zz", and "f" are special.
 * <p>
 * Return the length of the longest special substring of s which occurs at least thrice, or -1 if no special substring occurs at least thrice.
 * <p>
 * A substring is a contiguous non-empty sequence of characters within a string.
 */
public class LongestSpesialThriceS {
    public int maximumLength(String s) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getKey().length() - a.getKey().length()));
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(String.valueOf(s.charAt(i)), map.getOrDefault(String.valueOf(s.charAt(i)), 0) + 1);

            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                int k = 1;
                while (i - k >= 0 && s.charAt(i) == s.charAt(i - k)) {
                    map.put(s.substring(i - k, i + 1), map.getOrDefault(s.substring(i - k, i + 1), 0) + 1);
                    k++;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        Map.Entry<String, Integer> longest = pq.poll();
        while (longest.getValue() < 3 && !pq.isEmpty()) {
            longest = pq.poll();
        }
        return longest.getValue() < 3 ? -1 : longest.getKey().length();
    }
}
