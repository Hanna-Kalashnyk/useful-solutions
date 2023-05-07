//You are given an array of strings words. Each element of words consists of two
// lowercase English letters.
//
//    Create the longest possible palindrome by selecting some elements from words and
//    concatenating them in any order. Each element can be selected at most once.
//
//    Return the length of the longest palindrome that you can create. If it is impossible
//    to create any palindrome, return 0.
//
//    A palindrome is a string that reads the same forward and backward.package leetcode;

import java.util.HashMap;

public class LongestPalindromeConcatenatingTwoLetterWords
{
    public int longestPalindrome(String[] words)
    {
        public static int doubl = 0;
        int count = 0;

        HashMap<String, Integer> fb = new HashMap<>();
       // HashMap<String, Integer> pairRepeat = new HashMap<>();
        for ( String word : words )
        {
            Character[] pair = new Character[2];
            String reversedWord = reversedWord(word);

            if ( fb.containsKey(word) && fb.get(word) > 0 )
            {
                count += 4;
                fb.replace(word, fb.get(word) - 1);

                if ( word.toCharArray()[1] == word.toCharArray()[0] )
                {
                    doubl -= 1;
                }

            }
            else
            {
                fb.put(reversedWord(word), fb.getOrDefault(reversedWord(word), 0) + 1);
                if ( word.toCharArray()[1] == word.toCharArray()[0] )
                {
                    doubl += 1;
                }
            }

        }
        if ( doubl > 0 )
        {
            count += 2;
        }
        return count;
    }


    String reversedWord(String word)
    {
        char[] charArray = { word.toCharArray()[1], word.toCharArray()[0] };
        return String.valueOf(charArray);
    }
}
