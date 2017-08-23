package pers.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/23.
 * Description:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * <p>
 * 将小于x的数放到前面,并保持原来的顺序
 */
public class _86_PartitionList
{
    public ListNode partition(ListNode head, int x)
    {
        if (head == null || head.next == null)
            return head;
        ListNode resHead = new ListNode(0);
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = resHead, p1 = pHead, p2 = head;
        while (p2 != null)
        {
            if (p2.val < x)
            {
                p1.next = p2.next;
                p2.next = null;

                p.next = p2;
                p = p2;
                p2 = p1.next;
            } else
            {
                p1 = p2;
                p2 = p2.next;
            }
        }
        p.next = pHead.next;
        return resHead.next;
    }
}
