package pers.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/19.
 * Description:
 */
public class Main1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            String[] str = in.nextLine().split(" ");
            int[] arr = new int[7];
            for (int i = 0; i < 7; i++)
                arr[i] = Integer.parseInt(str[i]);
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 1; i <= 5; i++)
                sum += arr[i];
            System.out.print(str[7] + " ");
            System.out.printf("%.2f", sum * 1.0 / 5);
            System.out.println();
        }
    }
}
