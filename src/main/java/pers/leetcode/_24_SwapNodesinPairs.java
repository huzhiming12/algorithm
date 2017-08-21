package pers.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/21.
 * Description:
 * 隔两个结点反转一次链表,如 1->2->3->4->5  返回:2->1->4->3->5
 */
public class _24_SwapNodesinPairs
{
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode pHead = new ListNode(0);
        ListNode pre = pHead, p1 = head, p2 = head.next;
        while (p1 != null && p2 != null)
        {
            ListNode next = p2.next;
            pre.next = p2;
            p2.next = p1;
            p1.next = next;

            pre = p1;
            p1 = next;
            if (next != null)
                p2 = next.next;
        }
        return pHead.next;
    }
}
