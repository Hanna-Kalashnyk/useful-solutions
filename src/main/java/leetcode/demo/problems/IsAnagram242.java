package leetcode.demo.problems;

import java.util.HashMap;

public class IsAnagram242
{
	public boolean isAnagram(String s, String t)
	{
		if (s.length() != t.length())
			return false;
		HashMap<Character, Integer> st = new HashMap<>();
		HashMap<Character, Integer> ts = new HashMap<>();
		for (int i = 0; i < s.length(); i++)
		{
			st.put(s.charAt(i), st.getOrDefault(s.charAt(i), 0) + 1);
			ts.put(t.charAt(i), ts.getOrDefault(t.charAt(i), 0) + 1);
		}
		return st.equals(ts);
	}
	
}
