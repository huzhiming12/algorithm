package pers.nowcoder.offer;

import pers.nowcoder.entity.RandomListNode;

/**
 * Created by huzhiming on 2017/7/11.
 * Description:
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 思路:在每个结点后面添加一个新节点,这些新节点作为复制的链表.
 * 主要步骤:1.在每个结点后面添加新结点 2.为每个新节点添加random指针 3.将旧链表与新链表分离.
 */
public class _25_复杂链表的复制
{
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        RandomListNode p = pHead;
        //在每个结点后面添加新节点
        while (p != null)
        {
            RandomListNode next = p.next;
            RandomListNode newNode = new RandomListNode(p.label);
            p.next = newNode;
            newNode.next = next;
            p = next;
        }
        p = pHead;
        //为每个新节点添加random指针
        while (p != null)
        {
            RandomListNode newNode = p.next;
            //p有random指针,新建的结点才会有random指针
            if (p.random != null)
                newNode.random = p.random.next;
            p = newNode.next;
        }
        RandomListNode res = pHead.next;
        RandomListNode p1 = res;
        p = pHead;
        //将新的结点和旧结点分离
        while (p != null)
        {
            RandomListNode next = p1.next;
            p.next = next;
            if (next != null)
                p1.next = next.next;
            p = p.next;
            p1 = p1.next;
        }
        return res;
    }
}
