package pers.nowcoder.moni;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/7/25.
 * Description:
 */
public class _制造回文串
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            String str = in.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++)
            {
                char s = str.charAt(i);
                if (map.containsKey(s))
                    map.put(s, map.get(s) + 1);
                else
                    map.put(s, 1);
            }
            Iterator iterator = map.entrySet().iterator();
            int res = 0;
            while (iterator.hasNext())
            {
                Map.Entry<Character,Integer> entry = (Map.Entry) iterator.next();
                if (entry.getValue() % 2 == 1)
                    res++;
            }
            System.out.println(res);
        }
    }
}
