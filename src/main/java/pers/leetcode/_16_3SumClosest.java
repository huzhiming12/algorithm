package pers.leetcode;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/3.
 * Description:
 * 给定n个整数的数组s，在s中找到三个整数，使得和最接近给定的数，目标。返回三个整数的和。
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * 思路: 思路和3Sum类似,先排序,然后固定一个值,另外两个值从两边往中间滑动
 */
public class _16_3SumClosest
{
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++)
        {
            int low = i + 1;
            int high = nums.length - 1;
            //如果是第一次计算,则结果就是sum
            if (i == 0)
                res = nums[i] + nums[low] + nums[high];
            while (low < high)
            {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < target)
                    low++;
                else if (sum > target)
                    high--;
                else
                    return target;
                if (Math.abs(target - sum) < Math.abs(target - res))
                    res = sum;
            }
        }
        return res;
    }
}
