package leetcode;

public class ValidPalindrome125
{
	public boolean isPalindrome(String s)
	{
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		return s.compareToIgnoreCase(new StringBuilder(s).reverse().toString()) == 0;
		
	}
}