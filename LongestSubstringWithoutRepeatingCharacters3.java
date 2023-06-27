package leetcode;

public class LongestSubstringWithoutRepeatingCharacters3
{
    public int lengthOfLongestSubstring(String s)
    {

        int length = s.length();
        if ( s.isEmpty() )
            return 0;
        if ( length == 0 || length == 1 )
            return length;
        s = s.replaceAll("\\s+", " ");

        Map<Character, Integer> chars = new HashMap<>();
        char[] charsArray = s.toCharArray();
        int maxUnrepited = 0;
        int result = 0;

        int leftSide = 0;
        if ( charsArray.length < 0 || charsArray.length > 50000 )
        {
            System.out.println("nums.length is OUT of restricted values");
        }

        for ( int i = 0; i < charsArray.length; i++ )
        {
            if ( !chars.containsKey(charsArray[i]) )
            {
                chars.put(charsArray[i], i);
                maxUnrepited = i - leftSide + 1;
            }
            else
            {
                leftSide = leftSide > (chars.get(charsArray[i])) ? leftSide : (chars.get(charsArray[i]) + 1);
                chars.put(charsArray[i], i);
                maxUnrepited = (i - leftSide + 1) > maxUnrepited ? (i - leftSide + 1) : maxUnrepited;
            }
            result = result >= maxUnrepited ? result : maxUnrepited;

        }
        return result = result >= maxUnrepited ? result : maxUnrepited;
    }
}