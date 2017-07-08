package pers.nowcoder.leetcode;

import pers.nowcoder.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * Created by huzhiming on 2017/6/26.
 * Description:
 */
public class PathSum
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int tempSum = root.val;
        TreeNode lastPop = new TreeNode(0);
        while (!stack.isEmpty())
        {
            TreeNode node = stack.peek();
            if (node.left != null && lastPop != node.left && lastPop != node.right)
            {
                tempSum += node.left.val;
                stack.push(node.left);
            } else if (node.right != null && lastPop != node.right)
            {
                tempSum += node.right.val;
                stack.push(node.right);
            } else
            {
                lastPop = stack.pop();
                if (tempSum == sum && lastPop.left == null && lastPop.right == null)
                    return true;
                tempSum -= lastPop.val;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        TreeNode next = new TreeNode(2);
        root.left = next;
        PathSum demo = new PathSum();
        System.out.println(demo.hasPathSum(root,3));

    }
}
