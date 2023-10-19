//Given a string s, return the longest
//palindromic substring in s.
package leetcode.demo.problems;

public class LongestPalindromicSubstring5
{
    public String longestPalindrome(String s)
    {

        String res = "";
        char[] chars = s.toCharArray();
        for ( int i = 0; i < chars.length; i++ )
        {
            res = longest(res, lookLongestPal(s, res, i, i));
            res = longest(res, lookLongestPal(s, res, i, i + 1));

        }
        return res;
    }

    private String lookLongestPal(String s, String res, int start, int end)
    {
        char[] chars = s.toCharArray();
        while ( start >= 0 && end < chars.length && chars[start] == chars[end] )
        {
            res = longest(res, s.substring(start, end + 1));
            end++;
            start--;
        }
        return res;
    }

    private String longest(String a, String b)
    {
        return a.length() > b.length() ? a : b;
    }

}