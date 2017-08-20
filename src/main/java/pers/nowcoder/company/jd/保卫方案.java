package pers.nowcoder.company.jd;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/18.
 * Description:
 */
public class 保卫方案
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = in.nextInt();
            int res = 0;
            HashSet<String> set = new HashSet<>();
            for (int low = 0; low < n; low++)
            {
                int max = 0;
                for (int i = 1; ; i++)
                {
                    int high = (low + i) % n;
                    if (high == low)
                        break;
                    if (max <= arr[high] && max <= arr[low])
                    {
                        String str = Math.min(low, high) + "-" + Math.max(low, high);
                        if (!set.contains(str))
                        {
                            res++;
                            set.add(str);
                        }
                        max = Math.max(max, arr[high]);
                    }
                    if (max > arr[high] && max > arr[low])
                        break;
                }
            }
            System.out.println(res);
        }
    }
}
