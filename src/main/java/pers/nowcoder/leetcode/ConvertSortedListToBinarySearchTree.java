package pers.nowcoder.leetcode;

import pers.nowcoder.leetcode.entity.ListNode;
import pers.nowcoder.leetcode.entity.TreeNode;

/**
 * Created by huzhiming on 2017/6/27.
 * Description: 将有序链表装换成二叉搜索树
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree
{
    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null)
            return null;
        return createTree(head);
    }

    public TreeNode createTree(ListNode begin)
    {
        ListNode mid = getMiddleNode(begin);
        TreeNode node = new TreeNode(mid.val);
        //如果链表中只有一个结点
        if (begin.next == null)
            return node;
        //将链表从中间分割
        ListNode pre = begin;
        while (pre != null && pre.next != mid)
            pre = pre.next;
        pre.next = null;

        ListNode next = mid.next;
        if (begin != null)
            node.left = createTree(begin);
        if (next != null)
            node.right = createTree(next);

        return node;
    }

    //获取链表中点
    public ListNode getMiddleNode(ListNode p)
    {
        if (p.next == null)
            return p;
        ListNode slow = p;
        ListNode fast = p;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        ConvertSortedListToBinarySearchTree demo = new ConvertSortedListToBinarySearchTree();
        TreeNode node = demo.sortedListToBST(head);

    }
}
