package pers.sort;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/20.
 * Description: 冒泡排序
 */
public class BubuleSort
{
    public static void main(String[] args)
    {
        int[] arr = {4, 1, 4, 3, 19, -4, 3, -90, 56, -12, -3, -4, 4, 5, 6};
        bubuleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubuleSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
