package pers.nowcoder.offer;

import pers.nowcoder.entity.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * <p>
 * 思路:
 * 1.遍历每个元素时将元素添加到List的第一个位置,这种方法插入List头效率比较低
 * 2.借助栈
 */
public class _3_从尾到头打印链表
{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode)
    {
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null)
        {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    //方法二
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode)
    {
        ListNode head = listNode;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null)
        {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty())
            res.add(stack.pop());

        return res;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4};
        System.out.println(printListFromTailToHead2(ListNode.createList(arr)));
    }
}
