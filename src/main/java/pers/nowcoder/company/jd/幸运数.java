package pers.nowcoder.company.jd;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/17.
 * Description:
 */
public class 幸运数
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int res = 0;
            for (int i = 1; i <= n; i++)
                if (sumOfNum(i) == sumOfNumBinary(i))
                    res++;
            System.out.println(res);
        }
    }

    public static int sumOfNum(int num)
    {
        int res = 0;
        while (num != 0)
        {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static int sumOfNumBinary(int num)
    {
        int res = 0;
        while (num != 0)
        {
            if ((num & 1) == 1)
                res++;
            num = num >> 1;
        }
        return res;
    }
}
