package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/19.
 * Description:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 */
public class _70_ClimbingStairs
{
    /**
     * 思路:迭代法
     */
    public int climbStairs(int n)
    {
        if (n < 3)
            return n;
        int a = 1, b = 2;
        int res = 0;
        for (int i = 3; i <= n; i++)
        {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
