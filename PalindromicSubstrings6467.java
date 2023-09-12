//Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.
package leetcode;

public class PalindromicSubstrings6467{
	int count=0;
	public int countSubstringsTheBest(String s) {
		for (int start = 0; start < s.length(); start++) {
			expandRange(s, start, start);
			expandRange(s, start, start + 1);
		}
		return count;
	}
	public void expandRange(String str, int begin, int end) {
		while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
			count++;
			begin--;
			end++;
		}
	}


	public int countSubstrings2(String S) {
		
		int len = S.length(), ans = 0;
		for (int i = 0; i < len; i++) {
			int j = i - 1, k = i;
			while (k < len - 1 && S.charAt(k) == S.charAt(k+1)) k++;
			ans += (k - j) * (k - j + 1) / 2;
			i = k++;
			while (j >= 0 && k < len && S.charAt(k++) == S.charAt(j--)) ans++;
		}
		return ans;
	}
}