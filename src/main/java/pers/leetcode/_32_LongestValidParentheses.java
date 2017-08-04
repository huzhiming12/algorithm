package pers.leetcode;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses
 * substring is "()()", which has length = 4.
 * <p>
 * 思路:用栈匹配括号
 */
public class _32_LongestValidParentheses
{
    public static int longestValidParentheses(String s)
    {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(')
                stack.push("(");
            else
            {
                int num = 0;
                boolean hashLeft = false;
                while (!stack.isEmpty() && stack.peek() != ")")
                {
                    String str = stack.pop();
                    if (str.equals("("))
                    {
                        num += 2;
                        hashLeft = true;
                        stack.push(num + "");
                        break;
                    } else
                    {
                        num += Integer.parseInt(str);
                    }
                }
                //没有找到匹配的左括号
                if (!hashLeft)
                {
                    if (num != 0)
                        stack.push(num + "");
                    stack.push(")");
                }
            }
        }
        int res = 0;
        int num = 0;
        while (!stack.isEmpty())
        {
            String str = stack.pop();
            if (str.equals("(") || str.equals(")"))
                num = 0;
            else
            {
                num += Integer.parseInt(str);
                res = Math.max(res, num);
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(longestValidParentheses(")())()())"));
    }
}
