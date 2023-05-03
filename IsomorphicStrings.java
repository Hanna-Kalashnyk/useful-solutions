//Given two strings s and t, determine if they are isomorphic.
//  Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//  All occurrences of a character must be replaced with another character
// while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
package leetcode;

public class IsomorphicStrings
{
    public boolean isIsomorphic(String s, String t)
    {
        if ( s.length() < 1 || s.length() > 520 || s.length() != t.length() )

        {
            System.out.println("out of constrains");
        }

        Map<Character, Character> mapst = new HashMap<>();
        Map<Character, Character> mapts = new HashMap<>();
        for (
            int i = 0; i < s.length(); i++ )

        {
            char chars = s.charAt(i);
            char chart = t.charAt(i);
            if ( chars < 0x7F || chart < 0x7F )
            {
                System.out.println("consist of not valid ascii character");
            }
            if ( mapst.containsKey(chars) && mapst.get(chars) != chart
                || mapts.containsKey(chart) && mapts.get(chart) != chars )
                return false;
            mapst.put(chars, chart);
            mapts.put(chart, chars);
        }
        return true;
    }
}