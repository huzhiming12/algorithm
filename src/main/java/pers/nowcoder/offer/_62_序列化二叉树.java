package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

import java.util.LinkedList;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class _62_序列化二叉树
{
    String Serialize(TreeNode root)
    {
        if (root == null)
            return "";
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        int cur = 0;
        int next = 1;
        ///按层次遍历二叉树
        while (!queue.isEmpty())
        {
            cur = next;
            next = 0;
            while (cur > 0)
            {
                TreeNode node = queue.poll();
                if (node == null)
                    builder.append("#,");
                else
                {
                    builder.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                    next += 2;
                }
                cur--;
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    TreeNode Deserialize(String str)
    {
        if (str == null || "".equals(str))
            return null;
        String[] items = str.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(items[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int k = 1;
        while (!queue.isEmpty() && k < items.length)
        {
            TreeNode parent = queue.poll();
            if (items[k].equals("#"))
                parent.left = null;
            else
            {
                parent.left = new TreeNode(Integer.parseInt(items[k]));
                queue.add(parent.left);
            }
            k++;
            if (items[k].equals("#"))
                parent.right = null;
            else
            {
                parent.right = new TreeNode(Integer.parseInt(items[k]));
                queue.add(parent.right);
            }
            k++;
        }
        return head;
    }
}
