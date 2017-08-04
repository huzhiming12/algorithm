package pers.nowcoder.offer;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class _56_链表中环的入口结点
{
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode p1 = getMeetingNode(pHead);
        if (p1 == null)
            return null;
        ListNode p2 = pHead;
        while (p1 != p2)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode getMeetingNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return fast;
        }
        return null;
    }
}
