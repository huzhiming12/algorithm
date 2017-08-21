package pers.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/21.
 * Description:
 * 隔K个结点反转一次链表 如1->2->3->4->5 返回:3->2->1->4->5
 */
public class _25_ReverseNodesinkGroup
{
    public static ListNode reverseKGroup(ListNode head, int k)
    {
        if (k<2)
            return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode pre = pHead, p1 = head;
        loop:
        while (p1 != null)
        {
            ListNode p2 = p1;
            for (int i = 0; i < k-1; i++)
            {
                if (p2.next != null)
                    p2 = p2.next;
                else
                    break loop;
            }

            ListNode next = p1.next;
            for (int i = 0; i < k - 1; i++)
            {
                p2 = next;
                next = next.next;
                p2.next = p1;
                p1 = p2;
            }
            //next = p2.next;
            p1 = pre.next;
            p1.next = next;
            pre.next = p2;
            pre = p1;
            p1 = next;
        }
        return pHead.next;
    }

    public static void main(String[] args)
    {
        ListNode p1 = ListNode.createList(new int[]{1, 2,3,4,5});
        ListNode.printListNode(reverseKGroup(p1, 2));
    }
}
