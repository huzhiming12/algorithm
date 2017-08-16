package pers.sort;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 */
public class HeapSort
{
    public static void main(String[] args)
    {
        int[] arr = {2, 4, 1, 8, 3, 7, -1, 7, 45, -23};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr)
    {
        for (int i = arr.length / 2; i >= 0; i--)
            heapAdjust(arr, i, arr.length - 1);

        int pos = arr.length - 1;
        while (pos > 0)
        {
            int temp = arr[0];
            arr[0] = arr[pos];
            arr[pos] = temp;
            pos--;
            heapAdjust(arr, 0, pos);
        }
    }

    public static void heapAdjust(int[] arr, int begin, int end)
    {
        int sc = arr[begin];
        for (int i = begin * 2 + 1; i < end; i = i * 2 + 1)
        {
            if (i + 1 <= end && arr[i] < arr[i + 1])
                i = i + 1;
            if (sc > arr[i])
                break;
            arr[begin] = arr[i];
            begin = i;
        }
        arr[begin] = sc;
    }
}
