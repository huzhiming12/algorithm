package pers.leetcode;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/19.
 * Description:
 */
class ListNode
{
    int m_nKey;
    ListNode m_pNext;

    public ListNode(int val)
    {
        this.m_nKey = val;
    }
}

public class Main2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int h = in.nextInt();
            ListNode head = new ListNode(h);
            for (int i = 1; i < n; i++)
            {
                int next = in.nextInt();
                int pre = in.nextInt();
                ListNode node = new ListNode(next);
                ListNode p = head;
                while (p.m_nKey != pre)
                {
                    p = p.m_pNext;
                }
                node.m_pNext = p.m_pNext;
                p.m_pNext = node;
            }
            int del = in.nextInt();
            ListNode p = new ListNode(-1);
            p.m_pNext = head;
            head = p;
            ListNode p1 = head;
            while (p1.m_nKey != del)
            {
                p = p1;
                p1 = p1.m_pNext;
            }
            p.m_pNext = p1.m_pNext;
            head = head.m_pNext;
            while (head != null)
            {
                System.out.print(head.m_nKey);
                head = head.m_pNext;
                if (head == null)
                    System.out.println();
                else
                    System.out.print(" ");
            }
        }
    }

}
