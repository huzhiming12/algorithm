package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/10.
 * Description:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 思路:二叉搜索树的后序遍历,最末尾的元素end将数组分割成两半,前半边全部小于end,后半边全部大于end.
 * 然后继续判断左右部分是否是二叉树的后序遍历
 */
public class _23_二叉搜索树的后序遍历序列
{
    public boolean VerifySquenceOfBST(int[] sequence)
    {
        if (sequence == null || sequence.length == 0)
            return false;
        return isPostOrder(0, sequence.length - 1, sequence);
    }

    public boolean isPostOrder(int begin, int end, int[] sequence)
    {
        if (begin >= end)
            return true;
        int mid = 0;
        while (sequence[mid] < sequence[end])
            mid++;
        //判断后半部分是否都是大于末尾元素
        for (int i = mid; i < end; i++)
            if (sequence[i] < sequence[end])
                return false;
        //判断左边部分和右边部分是否都是后序遍历
        return isPostOrder(begin, mid - 1, sequence) && isPostOrder(mid, end - 1, sequence);
    }

}
