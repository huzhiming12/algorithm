package pers.leetcode.contest46;

import pers.nowcoder.entity.TreeNode;

import java.util.LinkedList;

/**
 * Created by huzhiming on 2017/8/20.
 * Description:
 */
class Data
{
    TreeNode node;
    int num;

    public Data(TreeNode node, int num)
    {
        this.node = node;
        this.num = num;
    }
}

public class _662_MaximumWidthofBinaryTree
{
    public int widthOfBinaryTree(TreeNode root)
    {
        LinkedList<Data> queue = new LinkedList<>();
        queue.add(new Data(root, 1));
        int cur = 1;
        int next = 1;
        int max = 0;
        while (!queue.isEmpty())
        {
            cur = next;
            next = 0;
            int begin = -1;
            int end = -1;
            while (cur > 0)
            {
                Data data = queue.poll();
                TreeNode node = data.node;
                if (begin == -1)
                    begin = data.num;
                end = data.num;

                if (node.left != null)
                {
                    queue.add(new Data(node.left, data.num * 2));
                    next++;
                }
                if (node.right != null)
                {
                    queue.add(new Data(node.right, data.num * 2 + 1));
                    next++;
                }
                cur--;
            }
            max = Math.max(max, end - begin + 1);
        }
        return max;
    }
}
