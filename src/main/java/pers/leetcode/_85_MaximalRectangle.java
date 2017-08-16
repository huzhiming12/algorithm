package pers.leetcode;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/8/12.
 * Description:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * For example, given the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 * <p>
 * <p>
 * 思路:将矩阵转化成如下矩阵,每行中的数值表示为这一列中,从这个数开始连续1的个数和
 * 4 0 3 0 0
 * 3 0 2 3 2
 * 2 1 1 2 1
 * 1 0 0 1 0
 * <p>
 * 然后对没一行求最大矩形,如:4,0,3,0,0  每个数字代表高度,求矩形的最大值
 */
public class _85_MaximalRectangle
{
    public int maximalRectangle(char[][] matrix)
    {
        if (matrix.length == 0)
            return 0;
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                arr[i][j] = matrix[i][j] - '0';
        //将数组中的每列求连续1的和
        for (int i = arr.length - 2; i >= 0; i--)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 1)
                    arr[i][j] = arr[i + 1][j] + 1;

        int max = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            int tmp = largestRectangleArea(arr[i]);
            max = Math.max(tmp, max);
        }
        return max;
    }

    public int largestRectangleArea(int[] arr)
    {
        if (arr.length < 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (stack.isEmpty() || arr[stack.peek()] < arr[i])
                stack.push(i);
            else
            {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                {
                    int index = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, arr[index] * width);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty())
        {
            int index = stack.pop();
            int width = stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1;
            max = Math.max(max, arr[index] * width);
        }
        return max;
    }


}
