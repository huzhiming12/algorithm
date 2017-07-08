package pers.nowcoder.leetcode;

/**
 * Created by huzhiming on 2017/6/28.
 * Description:
 * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 * The number of ways decoding"12"is 2.
 */
public class DecodeWays
{
    public int numDecodings(String s)
    {
        if (s == null || "".equals(s))
            return 0;
        int len = s.length();
        //dp[i] 表示从 前i个字符 有dp[i]中解析方式
        //dp[i] = dp[i-1]+dp[i-2]
        //或者 dp[i]=dp[i-1]  如何s第i-1和第位组成的数字大于26
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++)
        {
            int num1 = Integer.parseInt(s.substring(i - 1, i));
            //ways1表示从0到i-1解析的方式
            int ways1 = 0;
            if (num1 != 0)
                ways1 = dp[i - 1];
            //ways2表示从0到i-2解析的方式
            int ways2 = 0;
            if (i - 2 >= 0)
            {
                int num2 = Integer.parseInt(s.substring(i - 2, i));
                //第一个字符不能是'0',并且数字小于等于26
                if (s.charAt(i - 2) != '0' && num2 <= 26 && num2 > 0)
                    ways2 = dp[i - 2];
            }
            dp[i] = ways1 + ways2;
        }
        return dp[len];
    }

    public static void main(String[] args)
    {
        DecodeWays demo = new DecodeWays();
        System.out.println(demo.numDecodings("11"));
    }
}
