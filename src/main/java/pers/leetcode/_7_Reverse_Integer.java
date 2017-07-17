package pers.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by huzhiming on 2017/7/16.
 * Description:
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class _7_Reverse_Integer
{
    public int reverse(int x)
    {
        boolean flag = false;
        if (x < 0)
        {
            flag = true;
            x = -x;
        }
        long res = 0;
        //倒置
        while (x != 0)
        {
            int temp = x % 10;
            x = x / 10;
            res = res * 10 + temp;
        }
        if (flag)
            res = -res;
        x = 0;
        if (res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE)
            x = (int) res;
        return x;
    }
}
