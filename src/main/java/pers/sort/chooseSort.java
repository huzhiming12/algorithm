package pers.sort;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/20.
 * Description:
 */
public class chooseSort
{
    public static void main(String[] args)
    {
        int[] arr = {3, 5, 13, -45, 5, 2, 6, 8, 3, -1, 5, 7};
        chooseSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void chooseSort(int[] arr)
    {
        int pos = arr.length - 1;
        while (pos > 0)
        {
            int max = 0;
            for (int i = 1; i <= pos; i++)
                if (arr[max] < arr[i])
                    max = i;
            int tmp = arr[max];
            arr[max] = arr[pos];
            arr[pos] = tmp;
            pos--;
        }
    }
}
