package pers.leetcode.contest41;

/**
 * Created by huzhiming on 2017/7/16.
 * Description:
 */
public class _643_MaximumAverageSubarrayI
{
    public double findMaxAverage(int[] nums, int k)
    {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i < k)
                sum += nums[i];
            else
            {
                max = max > sum ? max : sum;
                sum -= nums[i - k];
                sum += nums[i];
            }
        }
        max = max > sum ? max : sum;
        return max * 1.0 / k;
    }

    public static void main(String[] args)
    {

    }
}
