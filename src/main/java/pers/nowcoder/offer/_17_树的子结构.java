package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/7/10.
 * Description:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 思路:先序遍历第一个二叉树,找到和第二颗树根节点相同的结点,然后从这个结点开始进一步判断第二颗树是否是子结构.
 * 如果是子结构,则直接返回false;如果不是,则继续先序遍历第一个树,接着找和根节点相同的结点,然后再进一步判断.
 * 如果最后第一颗树遍历完还未判定是子结构,则返回false.
 */
public class _17_树的子结构
{
    public boolean HasSubtree(TreeNode root1, TreeNode root2)
    {
        if (root2 == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        //非递归中序遍历二叉树
        while (!stack.isEmpty() || root1 != null)
        {
            while (root1 != null)
            {
                //如果当前结点的值和子树的根节点相同,则进一步判断是否是子树结构
                if (root1.val == root2.val)
                {
                    boolean res = isSubTree(root1, root2);
                    if (res)
                        return res;
                }
                stack.push(root1);
                root1 = root1.left;
            }
            if (!stack.isEmpty())
            {
                root1 = stack.pop();
                root1 = root1.right;
            }
        }
        return false;
    }

    //判断是否是子结构
    public boolean isSubTree(TreeNode root1, TreeNode root2)
    {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val)
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        return false;
    }


}
