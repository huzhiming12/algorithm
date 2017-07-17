package pers.nowcoder.offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by huzhiming on 2017/7/13.
 * Description:
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 */
public class _31_整数中1出现的次数
{
    public static int NumberOf1Between1AndN_Solution(int n)
    {
        int res = 0;
        int len = String.valueOf(n).length();
        //求出0-9,0-99,0-999……1出现的个数
        int[] base = new int[len + 1];
        base[0] = 0;
        base[1] = 1;
        int num = 1;
        for (int i = 1; i <= len; i++)
        {
            base[i] = 10 * base[i - 1] + num;
            num *= 10;
        }
        int i = len;
        //假设789,则分为0-699和700-789中1的个数,
        //其中0-699有7个0-99,和100个1开头的数
        //而700-789 可以看成是0-89
        while (n != 0)
        {
            int front = n / num;
            if (front == 1)
            {
                res += base[i] + (n - front * num + 1);
            } else if (front > 1)
            {
                res += base[i] * front + num;
            }
            n = n - front * num;
            num /= 10;
            i--;
        }
        return res;
    }

    public static void numOf1(int num)
    {
        int res = 0;
        for (int i = 1; i <= num; i++)
        {
            int a = i;
            while (a != 0)
            {
                int temp = a % 10;
                if (temp == 1)
                    res++;
                a /= 10;
            }
        }
        System.out.println(res);
    }


    public static void main(String[] args)
    {
        numOf1(1212);
        System.out.println(NumberOf1Between1AndN_Solution(1212));
    }
}
