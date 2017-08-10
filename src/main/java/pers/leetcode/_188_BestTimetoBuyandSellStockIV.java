package pers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/9.
 * Description:
 */
public class _188_BestTimetoBuyandSellStockIV
{
    public int maxProfit(int k, int[] prices)
    {
        if (k >= prices.length / 2)
            return bestSove(prices);
        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k + 1];
        for (int price : prices)
        {
            for (int i = 1; i <= k; i++)
            {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }

    //当可以买卖的次数大于length/2时,则变成可以无数次买卖
    public int bestSove(int[] prices)
    {
        int total = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > prices[i - 1])
                total += prices[i] - prices[i - 1];
        }
        return total;
    }
}
