package pers.nowcoder.company.toutiao;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/22.
 * Description:
 */
public class Main3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++)
            {
                int x = in.nextInt();
                int y = in.nextInt();
                arr[i][0] = x;
                arr[i][1] = y;
            }
            boolean[] flag = new boolean[n];
            for (int i = 0; i < n - 1; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1])
                        flag[j] = true;
                    else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                        flag[i] = true;
                }
            }
            for (int i = 0; i < n; i++)
                if (flag[i] == false)
                    System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
