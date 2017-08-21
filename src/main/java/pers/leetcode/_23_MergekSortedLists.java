package pers.leetcode;

import pers.nowcoder.entity.ListNode;

/**
 * Created by huzhiming on 2017/8/21.
 * Description:
 * 合并k个有序链表
 */
public class _23_MergekSortedLists
{
    public static ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0)
            return null;
        int len = 0;
        //清除空链表
        for (int i = 0; i < lists.length; i++)
        {
            if (lists[i] != null)
                lists[len++] = lists[i];
        }
        if (len == 0)
            return null;

        ListNode head = new ListNode(0);
        ListNode p = head;
        //构造初始堆
        for (int i = len / 2; i >= 0; i--)
            adjust(lists, i, len - 1);


        while (len > 0)
        {
            ListNode node = lists[0];
            p.next = node;
            p = p.next;
            node = node.next;
            if (node == null)
            {
                len--;
                lists[0] = lists[len];
            } else
                lists[0] = node;
            adjust(lists, 0, len - 1);
        }
        return head.next;
    }

    //堆调整
    public static void adjust(ListNode[] nodes, int s, int end)
    {
        ListNode src = nodes[s];
        for (int i = s * 2 + 1; i <= end; i = i * 2 + 1)
        {
            if (i + 1 <= end && nodes[i].val > nodes[i + 1].val)
                i++;
            if (src.val < nodes[i].val)
                break;
            nodes[s] = nodes[i];
            s = i;
        }
        nodes[s] = src;
    }

    public static void main(String[] args)
    {
        ListNode p1 = ListNode.createList(new int[]{1, 8});
        ListNode p2 = ListNode.createList(new int[]{3, 6});
        ListNode p3 = ListNode.createList(new int[]{4, 9});
        ListNode p4 = ListNode.createList(new int[]{2, 7});
        ListNode p5 = ListNode.createList(new int[]{0, 5, 10});

        ListNode[] arr = {p1, p2, p3, p4, p5};

        ListNode.printListNode(mergeKLists(arr));
    }
}
