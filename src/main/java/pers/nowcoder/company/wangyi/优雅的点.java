package pers.nowcoder.company.wangyi;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/12.
 * Description:
 */
public class 优雅的点
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int r = (int) Math.sqrt(n);
            int res = 0;
            int low = 0;
            int high = r;
            while (low <= high)
            {
                int tmp = low * low + high * high;
                if (tmp == n)
                {
                    if (low == high || low == 0)
                        res += 4;
                    else
                        res += 8;
                    low++;
                } else if (tmp < n)
                    low++;
                else
                    high--;
            }
            System.out.println(res);
        }
    }

}
