package pers.nowcoder.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by huzhiming on 2017/6/19.
 * Description:
 */
public class WordBreak
{
    boolean[] flag;

    public boolean wordBreak(String s, Set<String> dict)
    {
        flag = new boolean[s.length() + 1];
        int maxLen = 0;
        Iterator<String> iterator = dict.iterator();
        while (iterator.hasNext())
        {
            String str = iterator.next();
            if (str.length() > maxLen)
                maxLen = str.length();
        }

        return findWords(s, dict, 0, maxLen);
    }

    public boolean findWords(String s, Set<String> dict, int begin, int maxLen)
    {
        if (begin == s.length())
            return true;
        if (flag[begin])
            return false;
        boolean hasWord = false;
        for (int i = begin + 1; i - begin <= maxLen && i <= s.length(); i++)
        {
            String temp = s.substring(begin, i);
            if (dict.contains(temp))
            {
                hasWord = true;
                boolean res = findWords(s, dict, i, maxLen);
                if (res)
                    return true;
            }
        }
        if (!hasWord)
            flag[begin] = true;

        return false;
    }

    public static void main(String[] args)
    {
        HashSet<String> dict = new HashSet<>();
        String[] arr = {"a","leet","code"};
        for (int i = 0; i < arr.length; i++)
            dict.add(arr[i]);
        String s = "leetcodeleet";
        WordBreak demo = new WordBreak();
        System.out.println(demo.wordBreak(s, dict));
    }
}
