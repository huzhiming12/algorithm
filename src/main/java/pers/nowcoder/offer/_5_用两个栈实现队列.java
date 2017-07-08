package pers.nowcoder.offer;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * 思路:stack1栈用来存储数据,添加时之间加入stack1栈
 * 出队列时,将stack1中的元素全部倒入stack2中,取出stack2中的栈顶元素,这个就是返回的结果.
 * 弹出栈顶后再将stack2中元素倒回stack1中
 */
public class _5_用两个栈实现队列
{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node)
    {
        stack1.push(node);
    }

    public int pop()
    {
        if (stack1 == null)
            return 0;

        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        int res = stack2.pop();
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return res;
    }
}
