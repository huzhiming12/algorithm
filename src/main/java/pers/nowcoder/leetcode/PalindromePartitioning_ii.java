package pers.nowcoder.leetcode;

/**
 * Created by huzhiming on 2017/6/28.
 * Description: 求字符串的最小分割,使所有子串都是回文串
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 *  
 */
public class PalindromePartitioning_ii
{

    public int minCut(String s)
    {
        if (s == null || s.equals(""))
            return 0;
        int len = s.length();
        int[] minCut = new int[len + 1];
        minCut[0] = -1;
        //最多每个字符分割一次,初始值都是长度-1
        for (int i = 1; i <= len; i++)
            minCut[i] = i - 1;
        //设cut[k]代表从头起长度为k时的解。X、Y代表长度，若XY中的那段为回文串， 则 cut[Y] = min(cut[Y], cut[X] + 1)
        for (int i = 0; i < len; i++)
        {
            //中间的回文串长度是奇数
            for (int j = 0; i + j < len && i - j >= 0; j++)
            {
                char c1 = s.charAt(i + j);
                char c2 = s.charAt(i - j);
                if (c1 == c2)
                    minCut[i + j + 1] = Math.min(minCut[i + j + 1], minCut[i - j] + 1);
                else
                    break;
            }
            //中间回文串的长度是偶数
            for (int j = 0; i + j < len && i - j - 1 >= 0; j++)
            {
                char c1 = s.charAt(i + j);
                char c2 = s.charAt(i - j - 1);
                if (c1 == c2)
                    minCut[i + j + 1] = Math.min(minCut[i + j + 1], minCut[i - j - 1] + 1);
                else
                    break;
            }
        }
        return minCut[len];
    }

    public static void main(String[] args)
    {
        PalindromePartitioning_ii demo = new PalindromePartitioning_ii();
        System.out.println(demo.minCut("aabcdaba"));
    }
}
