package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class _59_对称的二叉树
{
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        return isMerrorTree(pRoot.left, pRoot.right);
    }

    boolean isMerrorTree(TreeNode p1, TreeNode p2)
    {
        if (p1 == null && p2 == null)
            return true;
        if ((p1 == null && p2 != null) || (p1 != null && p2 == null))
            return false;
        if (p1.val == p2.val)
            return isMerrorTree(p1.left, p2.right) && isMerrorTree(p1.right, p2.left);
        return false;
    }
}
