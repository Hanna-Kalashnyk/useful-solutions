package leetcode.demo.problems;
/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase
 * English character. You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepetingCharacterReplasment424 {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int maxFr = 0;
        int[] frequencty = new int[26];
        for (int end = 0; end < s.length(); end++) {
            int ch = s.charAt(end) - 'A';
            frequencty[ch]++;
            maxFr = Math.max(frequencty[ch], maxFr);
            if (end - start + 1 - maxFr > k && start <= end) {
                frequencty[s.charAt(start) - 'A']--;
                start++;
            }
            max = end - start + 1;
        }
        return max;
    }
}