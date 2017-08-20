package pers.leetcode.contest46;

import pers.nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by huzhiming on 2017/8/20.
 * Description:
 */
public class _663_EqualTreePartition
{
    ArrayList<Integer> list = new ArrayList<>();

    public boolean checkEqualTree(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
            return false;
        int sum = visitTree(root);
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) * 2 == sum)
                return true;
        }
        return false;
    }

    public int visitTree(TreeNode node)
    {
        int sum = 0;
        if (node.left != null)
            sum += visitTree(node.left);
        if (node.right != null)
            sum += visitTree(node.right);
        sum += node.val;
        list.add(sum);
        return sum;
    }
}
