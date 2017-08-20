package pers.sort;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/20.
 * Description: 插入排序
 */
public class InsertSort
{
    public static void main(String[] args)
    {
        int[] arr = {45, 2, 0, 5, 28, 45, 20, -4, -57, 245, 199};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int tmp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--)
            {
                if (arr[j] > tmp)
                    arr[j + 1] = arr[j];
                else
                    break;
            }
            arr[++j] = tmp;
        }
    }
}
