package pers.nowcoder.offer;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/7/17.
 * Description:
 * 输入两个链表，找出它们的第一个公共结点
 * <p>                                                             &公共结点
 * 思路: 分别遍历两个链表,  ======--- 链表1  两个链表合并起来  ======---+++---
 * =                       +++--- 链表2                 +++---======---
 * 由上图可以知道,合并起来之后,同时遍历肯定能找到公共结点
 */
public class _36_两个链表的第一个公共结点
{
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2)
    {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2)
        {
            if (p1 == null)
                p1 = pHead2;
            else
                p1 = p1.next;
            if (p2 == null)
                p2 = pHead1;
            else
                p2 = p2.next;
        }
        return p1;
    }
}
