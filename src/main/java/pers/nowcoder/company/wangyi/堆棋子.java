package pers.nowcoder.company.wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/12.
 * Description:
 */
public class 堆棋子
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = Integer.parseInt(in.nextLine().toString());
            long[] x = new long[n];
            long[] y = new long[n];
            String[] str1 = in.nextLine().split(" ");
            String[] str2 = in.nextLine().split(" ");
            for (int i = 0; i < n; i++)
            {
                x[i] = Long.parseLong(str1[i]);
                y[i] = Long.parseLong(str2[i]);
            }
            if (n == 1)
            {
                System.out.println(0 + " ");
                continue;
            }
            ArrayList<ArrayList<Long>> distance = new ArrayList<>();
            for (int i = 0; i < n; i++)
                distance.add(new ArrayList<Long>());
            //计算以i为中心,其他点到i的距离
            for (int i = 0; i < n - 1; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    long tmp = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                    distance.get(i).add(tmp);
                    distance.get(j).add(tmp);
                }
            }

            //排序
            for (int i = 0; i < n; i++)
            {
                Collections.sort(distance.get(i));
            }

            for (int i = 0; i < n; i++)
            {
                ArrayList<Long> list = distance.get(i);
                for (int j = 1; j < list.size(); j++)
                {
                    list.set(j, list.get(j) + list.get(j - 1));
                }
            }

            System.out.print(0 + " ");
            for (int i = 0; i < n - 1; i++)
            {
                long min = Long.MAX_VALUE;
                for (int j = 0; j < n; j++)
                {
                    min = Math.min(distance.get(j).get(i), min);
                }
                System.out.print(min);
                if (i != n - 2)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
