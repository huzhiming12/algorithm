package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/2.
 * Description:
 */
public class _27_Remove_Element
{
    public int removeElement(int[] nums, int val)
    {
        if (nums == null || nums.length == 0)
            return 0;
        //记录val的个数
        boolean hasValue = false;

        int pos = nums.length - 1;
        for (int i = 0; i <= pos; i++)
        {
            if (nums[i] == val)
            {
                hasValue = true;
                while (pos > i && nums[pos] == val)
                    pos--;
                nums[i] = nums[pos];
                nums[pos] = val;
            }
        }
        if (!hasValue)
            return pos+1;
        return pos;
    }
}
