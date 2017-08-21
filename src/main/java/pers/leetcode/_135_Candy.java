package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/20.
 * Description:
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class _135_Candy
{
    public static int candy(int[] ratings)
    {
        int len = ratings.length;
        int[] num = new int[len];
        num[0] = 1;
        //先从左到右遍历,升序则从1开始往上累加,一旦有非升序,则当前值设为1
        for (int i = 1; i < len; i++)
        {
            //升序,则所得糖果数量是前者数量加1
            if (ratings[i] > ratings[i - 1])
                num[i] = num[i - 1] + 1;
            else //一旦非升序,则从1 开始算
                num[i] = 1;
        }
        //从右到左,检查升序的值
        for (int i = len - 2; i >= 0; i--)
        {
            //升序的话糖果数量是 当前值或者后面的糖果数加1,这两者的较大值
            if (ratings[i] > ratings[i + 1])
                num[i] = Math.max(num[i + 1] + 1, num[i]);
        }
        int res = 0;
        for (int i = 0; i < len; i++)
            res += num[i];
        return res;
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 6, 7, 8, 5, 3, 6, 9};
        System.out.println(candy(arr));
    }
}
