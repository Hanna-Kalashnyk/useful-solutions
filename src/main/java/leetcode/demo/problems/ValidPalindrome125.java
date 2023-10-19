//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
// and removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
package leetcode.demo.problems;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        return s.compareToIgnoreCase(new StringBuilder(s).reverse().toString()) == 0;

    }

    public boolean isPalindromeWithoutRegExpressions(String s) {

        if(s.isBlank()) return true;
        int l = 0;
        int h = s.length() - 1;
        while( l <= h ){
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < s.length() - 1) l++;
            while (!Character.isLetterOrDigit(s.charAt(h)) && h > 0 ) h--;
            if(l <= h && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(h)))return false;

            l++; h--;
        }
        return  true;
    }
}
