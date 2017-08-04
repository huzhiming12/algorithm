package pers.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/4.
 * Description: 链表反转
 */
public class _206_ReverseLinkedList
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while (p2 != null)
        {
            ListNode tail = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tail;
        }
        return p1;
    }
}
