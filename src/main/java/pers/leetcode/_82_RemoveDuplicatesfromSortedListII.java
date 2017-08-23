package pers.leetcode;

import pers.nowcoder.entity.ListNode;

import java.util.List;

/**
 * Created by huzhiming on 2017/8/23.
 * Description:
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p>
 * 删除链表中重复结点
 */
public class _82_RemoveDuplicatesfromSortedListII
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = pHead;
        ListNode p1 = head, p2 = head;
        while (p2 != null)
        {
            if (p1.val == p2.val)  //  1 -> 1
                p2 = p2.next;
            else
            {
                if (p1.next == p2)  //1->2
                {
                    p.next = p1;
                    p = p.next;
                    p1 = p2;
                    p2 = p2.next;
                } else  // 1->1->2
                {
                    p1 = p2;
                    p2 = p2.next;
                }
            }
        }
        if (p1.next != null)
            p.next = null;
        else
            p.next = p1;
        return pHead.next;
    }
}
