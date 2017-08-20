package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/19.
 * Description:
 * A message containing letters from A-Z is being encoded to
 * numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */
public class _91_DecodeWays
{
    public static int numDecodings(String s)
    {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[1] = dp[0] = 1;
        for (int i = 2; i <= s.length(); i++)
        {
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (s.charAt(i - 1) == '0')
            {
                if (num > 26 || num <= 0)
                    return 0;
                dp[i] = dp[i - 2];
            } else
            {
                //如果当前字符和前一个字符组成的数组大于26 或者前一个字符是0
                if (num > 26 || s.charAt(i - 2) == '0')
                    dp[i] = dp[i - 1];
                else
                    dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args)
    {
        System.out.println(numDecodings("0000"));
    }
}
