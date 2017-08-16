package pers.nowcoder.company.wangyi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/12.
 * Description:
 */
public class 跳石板
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int N = in.nextInt();
            int M = in.nextInt();
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(N);
            int[] dp = new int[M + 1];
            while (!queue.isEmpty())
            {
                int pos = queue.poll();
                for (int i = 2; i <= pos / 2 && pos + i <= M; i++)
                {
                    if (pos % i == 0)
                    {
                        if (!queue.contains(pos + i))
                            queue.add(pos + i);
                        if (dp[pos + i] == 0)
                            dp[pos + i] = 1 + dp[pos];
                        else
                            dp[pos + i] = Math.min(dp[pos] + 1, dp[pos + i]);
                    }
                }
            }
            System.out.println(dp[M]);
        }
    }

}
