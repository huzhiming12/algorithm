package pers.nowcoder.company.meituan;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by huzhiming on 2017/7/25.
 * Description:
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。
 * 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 * <p>
 * 思路: 定义一个maxStack,lastIndexStack.遍历数组元素时,
 * 如果当前maxStack栈为空,或maxStack 栈顶元素小于等于当前元素,则arr[i]进max栈,下标i进lastIndex 栈;
 * 如果栈顶元素大于当前元素,则max栈出栈,lastIndexStack出栈,直到栈顶元素小于当前元素.同时计算以栈顶元素为
 * 高度时的面积 area = maxStack.peek()*(i-lastIndexStack.peek());
 */
public class _最大矩形面积
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = in.nextInt();
            Stack<Integer> maxStack = new Stack<>();
            Stack<Integer> lastIndexStack = new Stack<>();
            int maxArea = arr[0];
            for (int i = 1; i < n; i++)
            {
                if (maxStack.isEmpty() || arr[i] > maxStack.peek())
                {
                    maxStack.push(arr[i]);
                    lastIndexStack.push(i);
                } else
                {
                    int lastIndex = 0;
                    while (!maxStack.isEmpty() && arr[i] < maxStack.peek())
                    {
                        lastIndex = lastIndexStack.peek();
                        //计算以栈顶元素为高度时的最大矩形面积
                        int tmp = (i - lastIndex) * maxStack.peek();
                        if (tmp > maxArea)
                            maxArea = tmp;
                        lastIndexStack.pop();
                        maxStack.pop();
                    }
                    maxStack.push(arr[i]);
                    lastIndexStack.push(lastIndex);
                }
            }
            while (!maxStack.isEmpty())
            {
                int tmp = maxStack.peek() * (n - lastIndexStack.peek());
                if (tmp > maxArea)
                    maxArea = tmp;
                maxStack.pop();
                lastIndexStack.pop();
            }
            System.out.println(maxArea);
        }
    }
}
