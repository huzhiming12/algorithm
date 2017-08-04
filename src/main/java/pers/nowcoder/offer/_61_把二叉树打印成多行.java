package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 */
public class _61_把二叉树打印成多行
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
        while (!queue.isEmpty())
        {
            cur = next;
            next = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (cur > 0)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
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
            res.add(list);
        }
        return res;
    }
}
