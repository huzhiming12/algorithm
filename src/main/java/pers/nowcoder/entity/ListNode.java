package pers.nowcoder.entity;

/**
 * Created by huzhiming on 2017/6/17.
 * Description:
 */
public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode(int x)
    {
        val = x;
        next = null;
    }

    public static ListNode createList(int[] arr)
    {
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++)
        {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head;
    }

    public static void printListNode(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}