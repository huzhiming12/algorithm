package pers.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/23.
 * Description:
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class _83_RemoveDuplicatesfromSortedList
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p1 = head, p2 = head, p = pHead;
        while (p2 != null)
        {
            if (p1.val == p2.val)
                p2 = p2.next;
            else
            {
                p.next = p1;
                p = p.next;
                p.next = null;
                p1 = p2;
                p2 = p2.next;
            }
        }
        p.next = p1;
        if (p1.next != null)
            p1.next = null;
        return pHead.next;
    }
}
