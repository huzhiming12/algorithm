package pers.nowcoder.leetcode;

import pers.nowcoder.leetcode.entity.ListNode;

/**
 * Created by huzhiming on 2017/6/17.
 * Description:
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList
{
    public ListNode insertionSortList(ListNode head)
    {
        ListNode min;
        ListNode pre;
        return null;
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 19, 14, 4, -3, 1, 8, 5, 11, 15};
        //int[] arr = {4, 2, 6, 1};
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++)
        {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        head = new SortList().sortList(head);
        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
