package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by huzhiming on 2017/7/10.
 * Description:
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * 思路:用队列记下当前访问结点的左右子节点,cur表示当前层还需要遍历个数,next表示下一层的结点个数
 */
public class _22_从上往下打印二叉树
{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1;
        int next = 1;
        while (!queue.isEmpty())
        {
            cur = next;
            next = 0;
            while (cur > 0)
            {
                TreeNode node = queue.poll();
                cur--;
                res.add(node.val);
                //将左右子节点加入队列中,并将下一层结点数增加
                if (node.left != null)
                {
                    next++;
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    next++;
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
