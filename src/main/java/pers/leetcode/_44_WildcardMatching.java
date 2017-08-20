package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/18.
 * Description:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false
 */
public class _44_WildcardMatching
{
    public static boolean isMatch(String s, String p)
    {
        int sL = s.length();
        int pL = p.length();
        //dp[i][j] 表示S前i个字符和P前j个字符是否匹配
        boolean[][] dp = new boolean[sL + 1][pL + 1];
        dp[0][0] = true;
        for (int j = 1; j <= pL; j++)
        {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
            for (int i = 1; i <= sL; i++)
            {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] //匹配0个字符
                            || dp[i - 1][j - 1]//匹配1个字符
                            || dp[i - 1][j]; //匹配多个字符
            }
        }
        return dp[sL][pL];
    }

    public static void main(String[] args)
    {
        System.out.println(isMatch("aa", "*"));
    }
}
