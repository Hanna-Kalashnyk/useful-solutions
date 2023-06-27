package leetcode;

import java.util.Stack;

public class ValidParentheses20
{
	public boolean isValid(String s)
	{
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{')
				stack.push(chars[i]);
			
			
			if (chars[i] == '}')
			{
				if (!stack.empty() && stack.peek() == '{')
				{
					stack.pop();
				}
				else
					return false;
			}
			
			if (chars[i] == ']')
			{
				if (!stack.empty() && stack.peek() == '[')
				{
					stack.pop();
				}
				else
					return false;
			}
			
			
			if (chars[i] == ')')
			{
				if (!stack.empty() && stack.peek() == '(')
				{
					stack.pop();
				}
				else
					return false;
			}
		}
		return stack.empty();
	}
}
