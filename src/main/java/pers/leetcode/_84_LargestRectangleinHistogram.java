package pers.leetcode;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */
public class _84_LargestRectangleinHistogram
{
    public static int largestRectangleArea(int[] heights)
    {
        if (heights.length < 1)
            return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++)
        {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i])
                stack.push(i);
            else
            {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                {
                    int index = stack.pop();
                    //
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    int area = width * heights[index];
                    max = Math.max(max, area);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty())
        {
            int index = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            int area = heights[index] * width;
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 3, 4, 4, 5, 3};
        System.out.println(largestRectangleArea(arr));
    }
}
