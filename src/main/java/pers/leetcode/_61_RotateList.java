package pers.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/23.
 * Description:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class _61_RotateList
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode slow = head, fast = head;
        int len = 0;
        //求出链表的长度
        while (fast != null)
        {
            fast = fast.next;
            len++;
        }
        k = k % len;
        if (k==0)
            return head;
        fast = head;
        //快指针先走k步
        while (k > 0)
        {
            fast = fast.next;
            k--;
        }
        //求出需要反转的链表头部
        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        //将要反转部分的尾结点指向当前的头结点head
        ListNode pHead = slow.next;
        slow.next = null;
        fast = pHead;
        while (fast.next != null)
            fast = fast.next;
        fast.next = head;
        return pHead;
    }
}
