package pers.leetcode;

import java.util.*;

/**
 * Created by huzhiming on 2017/8/20.
 * Description:
 */
public class _316_RemoveDuplicateLetters
{
    public static String removeDuplicateLetters(String s)
    {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Character> keys = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!map.containsKey(c))
            {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(c, list);
                keys.add(c);
            }
            map.get(c).add(i);
        }
        Collections.sort(keys);
        StringBuilder builder = new StringBuilder();
        while (keys.size() > 0)
        {
            for (int i = 0; i < keys.size(); i++)
            {
                char c = keys.get(i);
                int index = map.get(c).get(0);
                boolean found = true;
                for (int j = 0; j < keys.size(); j++)
                {
                    if (j != i)
                    {
                        char c1 = keys.get(j);
                        ArrayList<Integer> list = map.get(c1);
                        if (index > list.get(list.size() - 1))
                        {
                            found = false;
                            break;
                        }
                    }
                }
                if (found)
                {
                    builder.append(c);
                    keys.remove(i);
                    for (int j = 0; j < keys.size(); j++)
                    {
                        char c1 = keys.get(j);
                        ArrayList<Integer> list = map.get(c1);
                        while (list.get(0) < index)
                            list.remove(0);
                    }
                    break;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
