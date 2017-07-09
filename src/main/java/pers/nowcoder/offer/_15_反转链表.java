package pers.nowcoder.offer;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/7/9.
 * Description:
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * <p>
 * 思路:定义两个指针一前一后,前指针pre 后指针p,遍历时定义中间变量temp存储p的next.
 * p.next 指向pre, 然后pre 和 p 都向后移动
 */
public class _15_反转链表
{
    public ListNode ReverseList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode p = head.next;
        head.next = null;
        while (p != null)
        {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }
}
