package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/21.
 * Description:
 */
public class _14_LongestCommonPrefix
{
    public String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 0)
            return "";
        int pos = 0;
        loop:
        while (true)
        {
            if (strs[0].length() <= pos)
                break;
            char c = strs[0].charAt(pos);
            for (int i = 1; i < strs.length; i++)
            {
                if (strs[i].length() <= pos)
                    break loop;
                if (strs[i].charAt(pos) != c)
                    break loop;
            }
            pos++;
        }
        return strs[0].substring(0, pos);
    }
}
