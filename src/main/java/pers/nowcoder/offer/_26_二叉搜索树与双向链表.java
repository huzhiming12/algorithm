package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

/**
 * Created by huzhiming on 2017/7/11.
 * Description:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 思路:中序遍历二叉树,head记录下当前访问的前一个结点,
 * 添加当前结点与head结点的关系即可,left表示pre指针,right表示next指针
 */
public class _26_二叉搜索树与双向链表
{
    TreeNode head = null;
    TreeNode res = null;

    public TreeNode Convert(TreeNode pRootOfTree)
    {
        visitTree(pRootOfTree);
        return res;
    }

    //中序遍历二叉树
    public void visitTree(TreeNode node)
    {
        if (node == null)
            return;
        visitTree(node.left);
        //head =null说明头结点还未确定
        if (head == null)
        {
            head = node;
            res = node;
        } else
        {   //head结点表示当前结点的前面的结点
            head.right = node;
            node.left = head;
            head = node;
        }
        visitTree(node.right);
    }
}
