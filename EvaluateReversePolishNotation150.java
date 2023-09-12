package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int res = oper(a, b, s.charAt(0));
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private int oper(int a, int b, char s) {
        if (s == ('+')) {
            return a + b;
        }
        if (s == ('-')) {
            return a - b;
        }
        if (s == ('/')) {
            return a / b;
        }
        if (s == ('*')) {
            return a * b;
        }
        return 0;
    }
}
