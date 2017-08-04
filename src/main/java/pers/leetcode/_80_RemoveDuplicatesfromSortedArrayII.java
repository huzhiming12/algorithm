package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/3.
 * Description:
 */
public class _80_RemoveDuplicatesfromSortedArrayII
{
    public int removeDuplicates(int[] nums)
    {
        if (nums == null || nums.length < 2)
            return nums.length;
        int index = 2;
        for (int i = 2; i < nums.length; i++)
        {
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }
}
