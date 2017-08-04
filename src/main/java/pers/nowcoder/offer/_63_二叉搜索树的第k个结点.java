package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 * <p>
 * 思路中序遍历
 */
public class _63_二叉搜索树的第k个结点
{
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        int pos = 0;
        while (!stack.isEmpty() || p != null)
        {
            while (p != null)
            {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty())
            {
                p = stack.pop();
                pos++;
                if (pos == k)
                    return p;
                p = p.right;
            }
        }
        return null;
    }
}
