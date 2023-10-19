package leetcode.demo.problems;

//Given a string s which consists of lowercase or uppercase letters,
// return the length of the longest palindrome that can be built with those letters.
import java.util.HashMap;
import java.util.Map;

public class LongestPalidrome409
{
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean isOdd = false;
        int maxPolLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch:chars)
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet())
        {
            maxPolLength += (entry.getValue()/2)*2;
            if (entry.getValue()%2 == 1) isOdd = true;
        }
        return isOdd == true?maxPolLength+1:maxPolLength;
    }
}