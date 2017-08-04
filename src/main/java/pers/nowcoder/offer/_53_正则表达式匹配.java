package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class _53_正则表达式匹配
{
    public static boolean match(char[] str, char[] pattern)
    {
        return dpMatch(str, pattern, 0, 0);
    }

    public static boolean dpMatch(char[] str, char[] pattern, int i, int j)
    {
        if (i >= str.length && j >= pattern.length)
            return true;
        if (i < str.length && j >= pattern.length)
            return false;
        if (j + 1 < pattern.length && pattern[j + 1] == '*')
        {
            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i]))
                return dpMatch(str, pattern, i, j + 2)  //匹配0个字符
                        || dpMatch(str, pattern, i + 1, j + 2) //匹配1个字符
                        || dpMatch(str, pattern, i + 1, j);// 匹配多个字符
            else //如果pattern和str 不相等只能匹配0个字符
                return dpMatch(str, pattern, i, j + 2);  //匹配0个字符
        }
        if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i]))
            return dpMatch(str, pattern, i + 1, j + 1);
        return false;
    }

    public static void main(String[] args)
    {
        String str = "ab";
        String pattern = ".*c";
        System.out.println(match(str.toCharArray(), pattern.toCharArray()));
    }

}
