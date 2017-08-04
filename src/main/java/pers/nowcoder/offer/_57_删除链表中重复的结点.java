package pers.nowcoder.offer;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class _57_删除链表中重复的结点
{
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(0);

        ListNode p = head;
        ListNode p1 = pHead;
        ListNode p2 = p1.next;
        while (p2 != null)
        {
            if (p1.val != p2.val)
            {
                if (p1.next == p2)
                {
                    // 2 3
                    p.next = p1;
                    p = p.next;
                    p1 = p1.next;
                    p2 = p2.next;
                } else
                {   // 2 2 3
                    p1 = p2;
                    p2 = p2.next;
                }
            } else
            {   /// 2 2 2
                p2 = p2.next;
            }
        }
        if (p1.next == null)
            p.next = p1;
        else
            p.next =null;
        return head.next;
    }
}
