package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class _5_LongestPalindromicSubstring
{
    int pos = 0;
    int len = 1;

    public String longestPalindrome(String s)
    {
        for (int i = 0; i < s.length() - 1; i++)
        {
            //回文串的长度是奇数
            exploreString(s, i, i);
            //回文串长度是偶数
            exploreString(s, i, i + 1);
        }
        return s.substring(pos, pos + len);
    }

    public void exploreString(String s, int low, int high)
    {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high))
        {
            low--;
            high++;
        }
        int temp = high - low - 1;
        if (len < temp)
        {
            len = temp;
            pos = low + 1;
        }
    }

}
