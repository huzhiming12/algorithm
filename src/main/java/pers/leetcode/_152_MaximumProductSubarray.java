package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class _152_MaximumProductSubarray
{
    public int maxProduct(int[] nums)
    {
        int res = nums[0];
        //记录下从0到i中连乘的最大值
        int max = nums[0];
        //记录下从0到i中连乘的最小值
        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            int temp = Math.max(nums[i] * max, nums[i] * min);
            temp = Math.max(temp, nums[i]);

            int temp1 = Math.min(nums[i] * min, nums[i] * max);
            temp1 = Math.min(temp1, nums[i]);
            max = temp;
            min = temp1;
            res = Math.max(max, res);
        }
        return res;
    }
}
