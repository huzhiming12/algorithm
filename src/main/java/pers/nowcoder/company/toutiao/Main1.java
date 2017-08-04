package pers.nowcoder.company.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/2.
 * Description:
 */
public class Main1
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
            Arrays.sort(arr);
            int res = 0;
            int pos = 0;
            while (pos < n)
            {
                if (n - pos == 1)
                {
                    res += 2;
                    break;
                } else if (n - pos == 2)
                {
                    int a = arr[pos];
                    int b = arr[pos + 1];
                    int temp = b - a;
                    if (temp <= 20)
                        res++;
                    else
                        res += 4;
                    break;
                } else
                {
                    int temp1 = arr[pos + 1] - arr[pos];
                    int temp2 = arr[pos + 2] - arr[pos + 1];
                    if (temp1 <= 10 && temp2 <= 10)
                        pos += 3;
                    else if (temp1 <= 10 && temp2 > 10)
                    {
                        res++;
                        pos += 2;
                    } else if (temp1 > 10 && temp1 <= 20)
                    {
                        res++;
                        pos += 2;
                    } else if (temp1 > 20)
                    {
                        res += 2;
                        pos += 1;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
