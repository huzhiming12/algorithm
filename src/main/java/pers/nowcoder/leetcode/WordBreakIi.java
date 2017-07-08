package pers.nowcoder.leetcode;

import java.util.*;

/**
 * Created by huzhiming on 2017/6/18.
 * Description: 分词
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where
 * each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
public class WordBreakIi
{
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> wordBreak(String s, Set<String> dict)
    {
        int maxLen = 0;
        Iterator<String> iterator = dict.iterator();
        while (iterator.hasNext())
        {
            String str = iterator.next();
            if (str.length() > maxLen)
                maxLen = str.length();
        }


        return res;
    }

    public void findWords(int start, boolean[][] flag, String s, StringBuilder builder)
    {
        if (start == flag.length)
        {
            res.add(builder.toString().trim());
            return;
        }
        for (int i = 0; i < flag[0].length; i++)
        {
            if (flag[start][i])
            {
                StringBuilder builder1 = new StringBuilder(builder);
                builder1.append(s.substring(start, start + i + 1) + " ");
                findWords(start + i + 1, flag, s, builder1);
            }
        }
    }

    public static void main(String[] args)
    {
        HashSet<String> dict = new HashSet<>();
        String[] arr = {"cat", "cats", "and", "sand", "dog"};
        for (int i = 0; i < arr.length; i++)
            dict.add(arr[i]);
        String s = "catsanddog";
        WordBreakIi demo = new WordBreakIi();
        System.out.println(demo.wordBreak(s, dict));
    }
}
