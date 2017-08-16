package pers.nowcoder.company.wangyi;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/12.
 * Description:
 */
public class 独立的小易
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int x = in.nextInt();
            int f = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            int res = 0;
            if (x * f < d)
            {
                res += f;
                d -= x * f;
                res += d / (x + p);
            } else
            {
                res = d / x;
            }
            System.out.println(res);
        }
    }
}
