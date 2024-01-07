package leetcode.demo.problems;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class RomanLetters {
    public int romanToInt(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        int i = 0;
        while (i < n) {
            if (chars[i] == 'I') {
                if (i < (n - 1) && chars[i + 1] == 'V') {
                    res += 4;
                    i++;
                } else if (i < (n - 1) && chars[i + 1] == 'X') {
                    res += 9;
                    i++;
                } else {
                    res += 1;
                }
            }
            if (chars[i] == 'X') {
                if (i < (n - 1) && chars[i + 1] == 'L') {
                    res += 40;
                    i++;
                } else if (i < (n - 1) && chars[i + 1] == 'C') {
                    res += 90;
                    System.out.println(i);
                    System.out.println(res);
                    i++;
                } else {
                    res += 10;
                }
            }
            if (chars[i] == 'C') {
                if (i < (n - 1) && chars[i + 1] == 'D') {
                    res += 400;
                    System.out.println(i);
                    System.out.println(res);
                    i++;
                } else if (i < (n - 1) && chars[i + 1] == 'M') {
                    res += 900;
                    System.out.println(i);
                    System.out.println(res);
                    i++;
                } else {
                    res += 100;
                    System.out.println(i);
                    System.out.println(res);
                }
            }
            if (chars[i] == 'L') res += 50;
            //  if (chars[i] == 'C') res += 100;
            if (chars[i] == 'D') res += 500;
            if (chars[i] == 'M') res += 1000;
            if (chars[i] == 'V') res += 5;
            System.out.println(i);
            System.out.println(res);
            i++;
        }

        return res;
    }

    public int romanToInt2(String s) {
        int ans = 0;

        // Map each Roman numeral character to its corresponding integer value
        int[] roman = new int[128];
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        for (int i = 0; i + 1 < s.length(); ++i) {
            // Check if the current numeral is smaller than the next numeral
            if (roman[s.charAt(i)] < roman[s.charAt(i + 1)])
                ans -= roman[s.charAt(i)];
            else
                ans += roman[s.charAt(i)];
        }

        // Add the value of the last numeral to the result
        return ans + roman[s.charAt(s.length() - 1)];
    }

    public int romanToIntBest(String s) {

        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}
/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */