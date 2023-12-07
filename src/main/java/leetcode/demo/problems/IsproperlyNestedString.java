package leetcode.demo.problems;

import java.util.Stack;

/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000];
 * string S is made only of the characters '(' and/or ')'.
 */
public class IsproperlyNestedString {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            }
            if (S.charAt(i) == ')') {
                if (stack.empty() || stack.peek() != '(') return 0;
                stack.pop();
            }
        }
        return 1;
    }
}
