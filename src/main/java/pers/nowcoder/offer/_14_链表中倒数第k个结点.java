package pers.nowcoder.offer;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/7/9.
 * Description:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 思路:设置一个头指针一个尾指针,头指针先走k步,然后尾指针再跟着走,
 * 当头指针到末尾时,此时的尾指针就是要返回的结果
 */
public class _14_链表中倒数第k个结点
{
    public ListNode FindKthToTail(ListNode head, int k)
    {
        ListNode pre = head;
        ListNode tail = head;
        //前面指针先走k步
        for (int i = 0; i < k; i++)
        {
            if (pre == null)
                return null;
            pre = pre.next;
        }
        while (pre != null)
        {
            pre = pre.next;
            tail = tail.next;
        }
        return tail;
    }
}
