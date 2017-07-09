package pers.nowcoder.offer;

import java.util.ArrayList;

/**
 * Created by huzhiming on 2017/7/9.
 * Description:
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * <p>
 * 思路:exponent用二进制表示,假设为1011,则结果是x^8 * x^2 * x1
 */
public class _12_数值的整数次方
{
    public double Power(double base, int exponent)
    {
        double res = 1.0;
        if (exponent < 0)
        {
            base = 1 / base;
            exponent = -exponent;
        }
        ArrayList<Integer> list = new ArrayList<>();
        //获取exponent的二进制表示
        while (exponent != 0)
        {
            int temp = exponent & 1;
            list.add(temp);
            exponent = exponent >> 1;
        }
        //计算指数幂
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (list.get(i) == 0)
                res = res * res;
            else
                res = res * res * base;
        }
        return res;
    }
}
