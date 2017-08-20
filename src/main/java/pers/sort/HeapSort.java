package pers.sort;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/11.
 * Description: 堆排序
 */
public class HeapSort
{
    public static void main(String[] args)
    {
        int[] arr = {2, -2, 1, 8, 3, 7, -1, 7, 45, -23};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr)
    {
        for (int i = arr.length / 2; i >= 0; i--)
            adjust(arr, i, arr.length - 1);
        int pos = arr.length - 1;
        while (pos > 0)
        {
            int tmp = arr[pos];
            arr[pos] = arr[0];
            arr[0] = tmp;
            pos--;
            adjust(arr, 0, pos);
        }
    }

    public static void adjust(int[] arr, int s, int high)
    {
        int src = arr[s];
        for (int i = s * 2 + 1; i <= high; i = i * 2 + 1)
        {
            if (i + 1 <= high && arr[i] < arr[i + 1])
                i = i + 1;
            if (src > arr[i])
                break;
            arr[s] = arr[i];
            s = i;
        }
        arr[s] = src;
    }
}
