package leetcode.demo.problems;

import java.util.Arrays;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutatinInString267
{
    public boolean checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int a[] = new int[26];
        int b[] = new int[26];
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        for (int i = 0; i < n; i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }
        if (n == m) return Arrays.equals(a, b);
        for (int i = 0; i < m - n; i++) {
            if (Arrays.equals(a, b)) return true;
            b[s2.charAt(i) - 'a']--;
            b[s2.charAt(n + i) - 'a']++;
        }
        return Arrays.equals(a, b);
    }
}
