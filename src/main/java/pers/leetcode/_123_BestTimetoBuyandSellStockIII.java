package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/9.
 * Description:
 * 股票最多两次交易,必须先买入再卖出
 */
public class _123_BestTimetoBuyandSellStockIII
{
    /**
     * 将数组分为两部分,分别求两部分的最大值
     */
    public static int maxProfit(int[] prices)
    {
        if (prices.length < 2)
            return 0;
        int len = prices.length;
        //求出从0-中的最大收益
        int[] leftMax = new int[len];
        int max = 0;
        int minPrice = prices[0];
        for (int i = 1; i < len; i++)
        {
            if (prices[i] > minPrice)
                max = Math.max(prices[i] - minPrice, max);
            else
                minPrice = prices[i];
            leftMax[i] = max;
        }
        //求出从i-n中的最大收益
        int[] rightMax = new int[len];
        int maxPrice = prices[len - 1];
        max = 0;
        for (int i = len - 2; i >= 0; i--)
        {
            if (prices[i] < maxPrice)
                max = Math.max(maxPrice - prices[i], max);
            else
                maxPrice = prices[i];
            rightMax[i] = max;
        }

        int res = 0;
        for (int i = 0; i < len - 1; i++)
            res = Math.max(leftMax[i] + rightMax[i], res);
        return res;
    }

    public int maxProfit1(int[] prices)
    {
        int firstBuy = Integer.MIN_VALUE;
        int secondBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondSell = 0;
        for (int price : prices)
        {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2};
        System.out.println(maxProfit(arr));
    }
}
