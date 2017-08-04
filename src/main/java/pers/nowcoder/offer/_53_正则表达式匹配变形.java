package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * '*'表示可以匹配多个字符,也可以匹配0个字符
 */
public class _53_正则表达式匹配变形
{
    public static boolean match(char[] str, char[] pattern)
    {
        return dpMatch(str, pattern, 0, 0);
    }

    public static boolean dpMatch(char[] str, char[] pattern, int i, int j)
    {
        if (i == str.length && j == pattern.length)
            return true;
        if (i < str.length && j == pattern.length)
            return false;

        if (pattern[j] == '*')
        {
            return dpMatch(str, pattern, i, j + 1)  //* 匹配0个字符
                    || dpMatch(str, pattern, i + 1, j + 1) //* 匹配1个字符
                    || dpMatch(str, pattern, i + 1, j);  // * 匹配多个字符
        }

        if (str[i] == pattern[j] || pattern[j] == '.')
        {
            return dpMatch(str, pattern, i + 1, j + 1);
        }
        return false;
    }

    public static void main(String[] args)
    {
        String str = "abfg";
        String pattern = ".b*fg*";
        System.out.println(match(str.toCharArray(), pattern.toCharArray()));
    }
}
