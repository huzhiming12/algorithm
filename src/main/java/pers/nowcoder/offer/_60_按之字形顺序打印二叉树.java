package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _60_按之字形顺序打印二叉树
{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int cur = 1;
        int next = 1;
        int level = 0;
        while (!queue.isEmpty())
        {
            cur = next;
            next = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (cur > 0)
            {
                TreeNode node = queue.poll();
                if (level % 2 == 0)
                    list.add(node.val);
                else
                    list.add(0, node.val);
                if (node.left != null)
                {
                    queue.add(node.left);
                    next++;
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                    next++;
                }
                cur--;
            }
            level++;
            res.add(list);
        }
        return res;
    }
}
