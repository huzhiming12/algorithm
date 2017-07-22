package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 思路:递归遍历二叉树,判断当前结点的左右子树的深度之差是否超过1
 */
public class _39_平衡二叉树
{
    boolean res = true;

    public boolean IsBalanced_Solution(TreeNode root)
    {
        visitTree(root);
        return res;
    }

    public int visitTree(TreeNode node)
    {
        if (node == null)
            return 0;
        int left = visitTree(node.left) + 1;
        int right = visitTree(node.right) + 1;
        if (res && Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right);
    }
}
