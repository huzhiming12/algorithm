package pers.nowcoder.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/6/17.
 * Description: 链表排序
 * Sort a linked list in O(n log n) time using constant space complexity.
 */


public class SortList
{
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head)
    {
        //获取链表的中间值,将一条链表分成两条
        ListNode mid = getMidNode(head);
        // 第二条链表的头结点
        ListNode next = mid.next;
        //从中间位置将链表分开
        mid.next = null;
        ListNode p1 = head, p2 = next;

        if (head != mid)
            p1 = mergeSort(head);
        if (next != null)
            p2 = mergeSort(next);
        //合并两个有序的链表
        return mergeList(p1, p2);
    }

    public ListNode mergeList(ListNode head1, ListNode head2)
    {
        //如果有一个链表为空的直接返回
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;

        //链表的头结点
        ListNode head = null;
        if (head1.val < head2.val)
        {
            head = head1;
            head1 = head1.next;
        } else
        {
            head = head2;
            head2 = head2.next;
        }
        ListNode p = head;
        while (head1 != null && head2 != null)
        {
            if (head1.val < head2.val)
            {
                p.next = head1;
                head1 = head1.next;
            } else
            {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 == null)
            p.next = head2;
        else
            p.next = head1;
        return head;
    }

    //返回链表的中间结点
    public ListNode getMidNode(ListNode head)
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
        int[] arr = {4, 19, 14, 5, -3, 1, 8, 5, 11, 15};
        //int[] arr = {4, 2, 6, 1};
        ListNode head = ListNode.createList(arr);

        head = new SortList().sortList(head);
        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
