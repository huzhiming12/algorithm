package pers.leetcode;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Created by huzhiming on 2017/8/16.
 * Description:
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class _97_InterleavingString
{
    public static boolean isInterleave(String s1, String s2, String s3)
    {
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (s3.length() == 0)
            return true;
        if (s1.length() == 0 || s2.length() == 0)
            return s3.equals(s1) || s3.equals(s2);
        //dp[i][j] 表示S1 0-i  S2 0-j  与S3 0-i+j是否匹配
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++)
            if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = true;

        for (int i = 1; i <= s2.length(); i++)
            if (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[0][i] = true;

        for (int i = 1; i <= s1.length(); i++)
        {
            for (int j = 1; j <= s2.length(); j++)
            {
                //S3 i+j-1 要么匹配 S1 i-1 要么匹配 S2 j-1,只要匹配一个即可
           dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args)
    {
        String s1 = "db";
        String s2 = "c";
        String s3 = "cdb";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
