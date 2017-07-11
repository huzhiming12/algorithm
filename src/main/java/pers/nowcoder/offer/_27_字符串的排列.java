package pers.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by huzhiming on 2017/7/11.
 * Description:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * <p>
 * 思路: 利用树的深度遍历
 */
public class _27_字符串的排列
{
    ArrayList<String> res = new ArrayList<>();
    char[] dic = null;
    char[] arr = null;
    boolean[] visited = null;
    HashSet<String> set = new HashSet<>();

    public ArrayList<String> Permutation(String str)
    {
        if (str == null || "".equals(str))
            return res;
        dic = new char[str.length()];
        arr = new char[str.length()];
        visited = new boolean[str.length()];

        dic = str.toCharArray();
        Arrays.sort(dic);
        dfs(0);
        return res;
    }

    public void dfs(int k)
    {
        //全部遍历完毕
        if (k == dic.length)
        {
            StringBuilder builder = new StringBuilder();
            for (char c : arr)
                builder.append(c);
            String str = builder.toString();
            if (!set.contains(str))
            {
                res.add(str);
                set.add(str);
            }
        } else
        {
            for (int i = 0; i < dic.length; i++)
            {
                //如果第i个元素没有访问,则访问第一个元素
                if (!visited[i])
                {
                    arr[k] = dic[i];
                    visited[i] = true;
                    dfs(k + 1);
                    //访问完之后将标志位复位
                    visited[i] = false;
                }
            }
        }
    }
}
