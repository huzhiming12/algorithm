package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/9.
 * Description:
 * 给定一组非负整数，您首先定位在数组的第一个索引中。
 * 数组中的每个元素表示您在该位置的最大跳转长度。
 * 确定是否能够到达最后一个索引。
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class _55_JumpGame
{

    /**
     * 思路一:贪心算法
     */
    public boolean canJump(int[] nums)
    {
        //表示前i个元素最远能到达的位置
        int reachable = 0;
        for (int i = 0; i < nums.length; i++)
        {
            //如果最远能到达的位置都小于i,说明不能到达i
            if (reachable < i)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    /**
     * 思路二:动态规划
     * dp[i]=Math.max(dp[i-1],i+A[i]);
     */
    public boolean canJump1(int[] nums)
    {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (dp[i-1]<i)
                return false;
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }
}
