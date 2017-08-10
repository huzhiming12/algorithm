package pers.leetcode;

import java.util.HashSet;

/**
 * Created by huzhiming on 2017/8/10.
 * Description:求最长不重复子串的长度
 */
public class _3_LongestSubstringWithoutRepeatingCharacters
{
    public int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.equals(""))
            return 0;
        int len = s.length();
        //pos[i]记录从pos[i]到i位置上没有重复的元素
        int[] pos = new int[len];
        pos[0] = 0;
        for (int i = 1; i < len; i++)
        {
            pos[i] = pos[i - 1];
            for (int j = pos[i - 1]; j < i; j++)
            {
                if (s.charAt(i) == s.charAt(j))
                    pos[i] = j + 1;
            }
        }

        int max = 1;
        for (int i = 0; i < len; i++)
        {
            int temp = i - pos[i] + 1;
            max = max > temp ? max : temp;
        }

        return max;
    }

    public int lengthOfLongestSubstring1(String s)
    {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int index = 0;
        int i = 0;
        while (i < s.length())
        {
            if (!set.contains(s.charAt(i)))
            {
                set.add(s.charAt(i++));
                max = Math.max(max, set.size());
            } else //如果包含,则把按顺序将s前面的字符串删除
                set.remove(s.charAt(index++));
        }
        return max;
    }
}
