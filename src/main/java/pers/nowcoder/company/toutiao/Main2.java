package pers.nowcoder.company.toutiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/2.
 * Description:
 * 字典序
 */
public class Main2
{
    public static void main(String[] args)
    {
        final Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int m = in.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 1; i <= n; i++)
                arr[i - 1] = i;
            Arrays.sort(arr, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    String num1 = o1.toString();
                    String num2 = o2.toString();
                    int pos = 0;
                    while (pos < num1.length() || pos < num2.length())
                    {
                        if (pos >= num1.length())
                            return -1;
                        if (pos >= num2.length())
                            return 1;
                        if (num1.charAt(pos) > num2.charAt(pos))
                            return 1;
                        else if (num1.charAt(pos) < num2.charAt(pos))
                            return -1;
                        else
                            pos++;
                    }
                    return 0;
                }
            });

            System.out.println(arr[m - 1]);

        }
    }
}
