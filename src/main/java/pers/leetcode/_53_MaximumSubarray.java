package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class _53_MaximumSubarray
{
    public int maxSubArray(int[] nums)
    {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubArray1(int[] nums)
    {
        int max = nums[0];
        int prefix = 0;
        for(int i=0;i<nums.length;i++)
        {
            prefix+=nums[i];
            if(max<prefix)
                max = prefix;
            if(prefix<=0)
                prefix=0;
        }
        return max;
    }
}
