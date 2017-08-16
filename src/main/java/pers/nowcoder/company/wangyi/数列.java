package pers.nowcoder.company.wangyi;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/12.
 * Description:
 */
public class 数列
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int k = in.nextInt();
            long res = 0;
            long dp[][] = new long[n][k + 1];
            for (int i = 0; i <= k; i++)
            {
                dp[0][i] = 1;
            }

            for (int i = 1; i < n; i++)
            {
                for (int j = 1; j <= k; j++)
                {
                    for (int num = 1; num <= k; num++)
                    {
                        if (num <= j || num % j != 0)
                            dp[i][j] += dp[i - 1][num];
                    }
                }
            }

            for (int i = 1; i <= k; i++)
                res += dp[n - 1][i];

            System.out.println(res % 1000000007);
        }
    }


}
