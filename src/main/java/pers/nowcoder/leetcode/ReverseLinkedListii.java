package pers.nowcoder.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/7/2.
 * Description: 链表反转
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 * return1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListii
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode frontTail = res;
        for (int i = 1; i < m; i++)
            frontTail = frontTail.next;

        ListNode pre = frontTail.next;
        ListNode p = pre.next;
        for (int i = m; i < n; i++)
        {
            if (p == null)
                break;
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        frontTail.next.next = p;
        frontTail.next = pre;
        return res.next;
    }

    public static void main(String[] args)
    {
        ReverseLinkedListii demo = new ReverseLinkedListii();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int node : arr)
        {
            p.next = new ListNode(node);
            p = p.next;
        }
        head = demo.reverseBetween(head, 1, 2);
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
