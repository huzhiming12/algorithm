package pers.nowcoder.offer;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/7/10.
 * Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * <p>
 * 思路: 定义两个栈,第一个栈存放所有入栈的数据,第二个栈min当入栈时比min栈顶元素小时,则加入min栈
 * 例如:stack栈:4,2,6,7,4,9,1;
 * /     min栈:4,2,1
 */
public class _20_包含min函数的栈
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node)
    {
        stack.push(node);
        if (min.isEmpty())
            min.push(node);
        else if (min.peek() >= node)
            min.push(node);
    }

    public void pop()
    {
        int temp = stack.pop();
        if (temp == min.peek())
            min.pop();
    }

    public int top()
    {
        if (!stack.isEmpty())
            return stack.peek();
        return 0;
    }

    public int min()
    {
        if (!min.isEmpty())
            return min.peek();
        return 0;
    }

}
