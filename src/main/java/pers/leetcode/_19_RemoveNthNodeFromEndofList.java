package pers.leetcode;

import pers.nowcoder.entity.ListNode;

import java.util.List;

/**
 * Created by huzhiming on 2017/8/21.
 * Description:
 * 删除链表中距离末尾位置为N的结点
 */
public class _19_RemoveNthNodeFromEndofList
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode slow = pHead;
        ListNode fast = pHead;
        ListNode pre = pHead;
        for (int i = 0; i < n; i++)
            fast = fast.next;

        while (fast != null)
        {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return pHead.next;
    }
}
