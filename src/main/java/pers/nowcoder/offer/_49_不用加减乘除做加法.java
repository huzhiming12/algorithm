package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/31.
 * Description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * <p>
 * 思路：位运算
 * 两个数异或：相当于每一位相加，而不考虑进位；
 * 两个数相与，并左移一位：相当于求得进位；
 * 将上述两步的结果相加
 */
public class _49_不用加减乘除做加法
{
    public int Add(int num1, int num2)
    {
        while (num2 != 0)
        {
            int t1 = num1 ^ num2;
            int t2 = (num1 & num2) << 1;
            num1 = t1;
            num2 = t2;
        }
        return num1;
    }
}
