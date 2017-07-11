package pers.nowcoder.offer;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/7/10.
 * Description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1
 * 是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * <p>
 * 思路:遍历popA序列,对于popA序列中的每个元素,都进行如下操作:
 * 假设popA中元素为B,从头遍历pushA,如果pushA元素与B不相等,则压入栈中;
 * 如果相同则直接跳出循环,记下pushA中位置pos,下次遍历pushA时从pos+1位置开始.
 * 如果遍历过程中没找到B元素,则判断栈顶是否和当前元素相同,相同则进行下一个元素判断.不相同则返回.
 */
public class _21_栈的压入弹出序列
{
    public static boolean IsPopOrder(int[] pushA, int[] popA)
    {
        if (pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        for (int i = 0; i < popA.length; i++)
        {
            boolean find = false;
            //将于当前元素不相同的压入栈中
            while (pos < pushA.length)
            {
                if (pushA[pos] == popA[i])
                {
                    find = true;
                    pos++;
                    break;
                } else
                    stack.push(pushA[pos++]);
            }
            //如果压栈过程中找不到,则判断栈顶元素是否和当前元素相同
            if (!find)
            {
                if (stack.peek() != popA[i])
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(arr1, arr2));
    }
}
