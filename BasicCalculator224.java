//Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
//
//Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().package leetcode;

import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {
        char[] chars = s.replaceAll("\\s", "").toCharArray();
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int rez = 0;
        int sign = 1;
        int stacksign;
        int stackrez;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
            } else if (c == '+') {
                rez = rez + sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                rez = rez + sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {

                stack.push(rez);
                stack.push(sign);
                rez = 0;
                sign = 1;
            } else if (c == ')') {
                rez += sign * number;
                number = 0;
                rez *= stack.pop();    //stack.pop() is the sign before the parenthesis
                rez += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if (number != 0) {
            rez += sign * number;
        }
        return rez;
    }
}