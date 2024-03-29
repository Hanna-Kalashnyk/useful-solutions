

package leetcode.demo.problems;

import java.util.Arrays;
import java.util.HashMap;

public class LongestCommonSubsequence1143
/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *  If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from
 *  the original string with some characters (can be none)
 *  deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
{
    int max = 0;
    int size = 0;

    int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        char[] charsi = text1.toCharArray();
        char[] charsj = text2.toCharArray();
        int n = Math.max(charsi.length, charsj.length);
        HashMap<Integer, Integer> ij = new HashMap<>();
        HashMap<Integer, Integer> ji = new HashMap<>();
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (charsi[i] == charsj[j]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public int longestCommonSubsequence1(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i1 = 1; i1 <= n1; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                int pick = 0, notpick = 0;
                if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1))
                    pick = 1 + dp[i1 - 1][i2 - 1];

                notpick = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);

                dp[i1][i2] = Math.max(pick, notpick);
            }
        }

        return dp[n1][n2];

    }
}

