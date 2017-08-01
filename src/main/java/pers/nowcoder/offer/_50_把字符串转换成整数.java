package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/31.
 * Description:
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * <p>
 * +2147483647
 * 1a33
 * 输出
 * <p>
 * 2147483647
 * 0
 */
public class _50_把字符串转换成整数
{
    public int StrToInt(String str)
    {
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9')
                res = res * 10 + c - '0';
            else
            {
                if (c == '+' && i == 0)
                    flag = true;
                else if (c == '-' && i == 0)
                    flag = false;
                else
                {
                    res = 0;
                    break;
                }
            }
        }
        if (!flag)
            res = -res;
        return res;
    }
}
