package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/19.
 * Description:
 * Given two words word1 and word2, find the minimum number of steps
 * required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 题意:将字符串1通过增删替方式转换成字符串2,最少需要几次
 */
public class _72_EditDistance
{
    public static int minDistance(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();
        //dp[i][j]表示 Word1 0-i 转换成Word2 0-j 最小操作数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int i = 1; i <= n; i++)
            dp[0][i] = i;

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                {
                    int a = dp[i][j - 1] + 1;//插入一个字符
                    int b = dp[i - 1][j] + 1;//删除一个字符
                    int c = dp[i - 1][j - 1] + 1;//替换一个字符
                    dp[i][j] = Math.min(Math.min(a, b), c);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args)
    {
        System.out.println(minDistance("abc", "bdab"));
    }
}
