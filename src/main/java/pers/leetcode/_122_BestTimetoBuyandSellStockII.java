package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/9.
 * Description:
 * 不限次数的买卖股票,但是必须先买再买,且不能交叉
 */
public class _122_BestTimetoBuyandSellStockII
{
    public int maxProfit(int[] prices)
    {
        int sumProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            //只要是递增的就买入并卖出
            if (prices[i] > prices[i - 1])
                sumProfit += prices[i] - prices[i - 1];
        }
        return sumProfit;
    }
}
