package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

import java.util.ArrayList;

/**
 * Created by huzhiming on 2017/7/10.
 * Description:
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 思路:利用非递归后序遍历二叉树
 */
public class _24_二叉树中和为某一值的路径
{
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayList<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        TreeNode lastOut = new TreeNode(0);
        int sum = root.val;
        while (!stack.isEmpty())
        {
            TreeNode node = stack.get(stack.size() - 1);
            if (node.left != null && node.left != lastOut && node.right != lastOut)
            {
                sum += node.left.val;
                stack.add(node.left);
            } else if (node.right != null && node.right != lastOut)
            {
                sum += node.right.val;
                stack.add(node.right);
            } else
            {
                lastOut = stack.get(stack.size() - 1);
                //如果是叶子结点,并且和等于目标值,则将stack中的全部值添加入到结果中
                if (lastOut.left == null && lastOut.right == null && sum == target)
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = 0; i < stack.size(); i++)
                        list.add(stack.get(i).val);
                    res.add(list);
                }
                sum -= lastOut.val;
                //移除栈顶元素
                stack.remove(stack.size() - 1);
            }
        }
        StringBuffer buffer;
        return res;
    }
}
