package pers.nowcoder.company.meituan;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/7/25.
 * Description:
 * 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
 */
public class _最长公共连续子串
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            //dp[i][j]表示字符串str1 从0-i,str2 从0-j中最长公共子串
            int[][] dp = new int[str1.length()][str2.length()];
            int max = 0;
            for (int i = 0; i < str1.length(); i++)
            {
                for (int j = 0; j < str2.length(); j++)
                {
                    if (str1.charAt(i) == str2.charAt(j))
                    {
                        if (i > 0 && j > 0)
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        else
                            dp[i][j] = 1;
                        if (max < dp[i][j])
                            max = dp[i][j];
                    }
                }
            }
            System.out.println(max);
        }
    }
}
