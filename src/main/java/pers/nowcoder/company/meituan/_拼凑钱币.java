package pers.nowcoder.company.meituan;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/7/25.
 * Description:
 * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，
 * 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 */
public class _拼凑钱币
{
    static int[] choice = {1, 5, 10, 20, 50, 100};

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            long[] dp = new long[n + 1];
            dp[0] = 1;
            //表示前i+1种面值的钱凑成j
            for (int i = 0; i < choice.length; i++)
            {
                for (int j = choice[i]; j <= n; j++)
                    dp[j] = dp[j] + dp[j - choice[i]];
            }
            System.out.println(dp[n]);
        }
    }
}
