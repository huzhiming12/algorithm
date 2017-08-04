package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeLinkNode;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */


public class _58_二叉树的下一个结点
{
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        //如果没有右子树
        if (pNode.right == null)
        {
            //没有右子树,且没有父节点
            if (pNode.next == null)
                return null;
            TreeLinkNode parent = pNode.next;
            //所在子树 在祖父结点的左子树上,第一个这样的祖父结点
            while (parent != null)
            {
                if (parent.left == pNode)
                    return parent;
                else
                {
                    pNode = parent;
                    parent = parent.next;
                }
            }
        } else
        {   //存在右子树的话,是右子树上的最左边的结点
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        return null;
    }
}
