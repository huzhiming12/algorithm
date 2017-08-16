package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 * Given a string s, partition s such that every substring of the partition
 * is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 题意:将字符串划分为n段,且每一段子串都是回文串
 */
public class _132_PalindromePartitioningII
{
    public static int minCut(String s)
    {
        if (s.length() <= 1)
            return 0;
        int n = s.length();
        //isPalindrome[i][j]=true 表示字符串 i到j是回文串
        boolean[][] isPalindrome = new boolean[n][n];
        //dp[i]表示字符从0到i的最小分割数
        int[] dp = new int[n];

        for (int i = 0; i < n; i++)
            dp[i] = i;

        for (int i = 1; i < n; i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                // j+1 到i-1是回文串
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || isPalindrome[j + 1][i - 1]))
                {
                    // 因为j+1到i-1是回文串,且si=sj  所以j到也是回文串
                    isPalindrome[j][i] = true;
                    dp[i] = Math.min(dp[i], j - 1 < 0 ? 0 : dp[j - 1] + 1);
                }
                //如果i不能匹配的话,则可以将第i个字符单独划分
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        String s = "bba";
        System.out.println(minCut(s));
    }

}
