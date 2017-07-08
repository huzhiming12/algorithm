package pers.nowcoder.offer;

import pers.nowcoder.entity.TreeNode;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 思路:前序遍历第一个元素为根,通过中序遍历找出根元素所在位置,然后将数组分割成两份,前半部分是左子树
 * 右半部分是右子树,再分别对左子树和右子树进行递归创建
 */
public class _4_重建二叉树
{
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in)
    {
        if (pre == null || in == null || pre.length != in.length)
            return null;
        return createTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode createTree(int[] pre, int l1, int r1, int[] in, int l2, int r2)
    {
        //左边界大于右边界,或者超出数组位置
        if (l1 > r1 || l1 >= pre.length)
            return null;

        TreeNode head = new TreeNode(pre[l1]);
        if (l1 == r1)
            return head;

        //表示根元素在中序遍历中的位置
        int pos = 0;
        while (l2 + pos <= r2 && in[l2 + pos] != pre[l1])
            pos++;

        head.left = createTree(pre, l1 + 1, l1 + pos, in, l2, l2 + pos - 1);
        head.right = createTree(pre, l1 + pos + 1, r1, in, l2 + pos + 1, r2);
        return head;
    }

    public static void main(String[] args)
    {
        int[] pre = {1, 2, 3, 4};
        int[] in = {4, 3, 2, 1};
        reConstructBinaryTree(pre, in);
    }
}
