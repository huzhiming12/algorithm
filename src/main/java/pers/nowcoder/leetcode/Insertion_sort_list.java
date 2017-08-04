package pers.nowcoder.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/2.
 * Description: 链表的插入排序
 */
public class Insertion_sort_list
{
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode node = head.next;
        head.next = null;

        while (node != null)
        {
            ListNode p = pHead;
            //p.next是第一个大于node的结点,否则p.next=null
            while (p.next != null && p.next.val < node.val)
                p = p.next;
            ListNode temp = p.next;
            p.next = node;
            node = node.next;
            p.next.next = temp;
        }
        return pHead.next;
    }
}
