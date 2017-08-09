package pers.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by huzhiming on 2017/8/9.
 * Description:
 * 给定一组非负整数，您首先定位在数组的第一个索引中。
 * 数组中的每个元素表示您在该位置的最大跳转长度。
 * 您的目标是以最小跳转次数到达最后一个索引。
 * 例如:
 * 给定的数组a [ 2,3,1,1,4 ]
 * 达到最后一个索引的最小跳转数是2。（从索引0跳到1步，然后跳3步到最后一个索引）。（1步）
 * You can assume that you can always reach the last index.
 */
public class _45_JumpGameII
{
    //这个方法时间超限
    public static int jump(int[] nums)
    {
        if (nums.length < 2)
            return 0;
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++)
            dp[i] = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++)
            {
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                if (i + j == nums.length - 1)
                    min = Math.min(min, dp[i + j]);
            }
        }
        return min;
    }

    public static int jump1(int[] nums)
    {
        //表示当前能达到的最远的距离
        int maxReach = 0;
        //表示上一步最远能到的距离
        int border = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == border)
            {
                step++;
                border = maxReach;
            }
        }
        return step;
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(jump(arr));
    }
}
