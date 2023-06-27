//Given two strings ransomNote and magazine, return true
// if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
package leetcode;

import java.util.HashMap;

public class RansomNote383
{
	public boolean canConstruct(String ransomNote, String magazine)
	{
		char[] noteChars = ransomNote.toCharArray();
		char[] magazChars = magazine.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char magazChar : magazChars)
		{
			map.put(magazChar, map.getOrDefault(magazChar, 0) + 1);
		}
		for (char notaChar : noteChars)
		{
			if (map.containsKey(notaChar))
			{
				if (map.get(notaChar) > 0)
				{
					map.put(notaChar, map.get(notaChar) - 1);
				}else return  false;
			}else return  false;
			
		}return true;
	}
}