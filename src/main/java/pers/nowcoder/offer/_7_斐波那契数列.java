package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * <p>
 * 思路:
 * 1.递归
 * 2.类似动态规划
 */
public class _7_斐波那契数列
{
    public int Fibonacci(int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //解法二
    public int Fibonacci1(int n)
    {
        if (n < 2)
            return n;
        int num1 = 0;
        int num2 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++)
        {
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }

}
