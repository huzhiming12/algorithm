package pers.nowcoder.leetcode;

import pers.nowcoder.leetcode.entity.ListNode;

/**
 * Created by huzhiming on 2017/6/17.
 * Description:
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList
{
    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode mid = getMid(head);

        ListNode head2 = mid.next;
        mid.next = null;
        head2 = inverseList(head2);
        ListNode head1 = head;
        head = mergeList(head1, head2);
    }

    public ListNode mergeList(ListNode p1, ListNode p2)
    {
        ListNode head = p1;
        while (p1 != null && p2 != null)
        {
            ListNode next1 = p1.next;
            p1.next = p2;
            ListNode next2 = p2.next;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
        return head;
    }

    //反转链表
    public ListNode inverseList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        while (p != null)
        {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            head = p;
            p = next;
        }
        return head;
    }

    // 获取链表的中间结点
    public ListNode getMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNode.createList(arr);
        new ReorderList().reorderList(head);
        ListNode.printListNode(head);
    }
}
