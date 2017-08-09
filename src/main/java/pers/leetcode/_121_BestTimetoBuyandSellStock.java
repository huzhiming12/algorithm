package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/9.
 * Description:一个数组,买入一次卖出一次,求最大的差值(收益)
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * <p>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 */
public class _121_BestTimetoBuyandSellStock
{
    public int maxProfit(int[] prices)
    {
        //dp[i]表示当前卖出能达到的最大收益
        int[] dp = new int[prices.length];
        int max = 0;
        for (int i = 1; i < prices.length; i++)
        {
            int temp = prices[i] - prices[i - 1];
            dp[i] = Math.max(temp + dp[i - 1], temp);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
