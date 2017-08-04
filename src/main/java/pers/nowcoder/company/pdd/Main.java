package pers.nowcoder.company.pdd;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 */

import java.util.*;

public class Main
{
    public static void main(String[] agrs)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++)
                h[i] = in.nextInt();
            int m = in.nextInt();
            int[] w = new int[m];
            for (int i = 0; i < m; i++)
                w[i] = in.nextInt();
            Arrays.sort(h);
            Arrays.sort(w);
            int res = 0;
            int pos = n - 1;
            for (int i = m - 1; i >= 0; i--)
            {
                while (pos >= 0)
                {
                    if (h[pos] <= w[i])
                    {
                        res++;
                        pos--;
                        break;
                    }
                    pos--;
                }
            }
            System.out.println(res);
        }
    }

}
