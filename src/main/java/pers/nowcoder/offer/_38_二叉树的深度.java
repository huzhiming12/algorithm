package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 * <p>
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 思路:递归遍历二叉树
 */
public class _38_二叉树的深度
{
    public int TreeDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left) + 1;
        int right = TreeDepth(root.right) + 1;
        return left > right ? left : right;
    }
}
