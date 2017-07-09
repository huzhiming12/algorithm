package pers.nowcoder.offer;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/7/9.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：定义新建一个头结点，遍历的时候将两个链表中较小的节点连接到新定义的节点上，
 * 最后将链表1或者链表2中剩下的节点加到新链表中
 */
public class _16_合并两个排序的链表
{
    public ListNode Merge(ListNode list1, ListNode list2)
    {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (list1 != null && list2 != null)
        {
            if (list1.val < list2.val)
            {
                p.next = list1;
                list1 = list1.next;
            } else
            {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        //将剩下的节点连接到新链表中
        if (list1 == null)
            p.next = list2;
        else
            p.next = list1;
        return head.next;
    }

}
