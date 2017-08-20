package pers.sort;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/6/17.
 * Description: 归并排序
 */
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr = {3, 5, 13, -45, 5, 2, 6, 8, 3, -1, 5, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high)
    {
        int mid = (low + high) / 2;
        if (low < mid)
            mergeSort(arr, low, mid);
        if (mid + 1 < high)
            mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high)
    {
        int[] tmp = new int[high - low + 1];
        int pos1 = low;
        int pos2 = mid + 1;
        int pos = 0;
        while (pos1 <= mid && pos2 <= high)
        {
            if (arr[pos1] < arr[pos2])
                tmp[pos++] = arr[pos1++];
            else
                tmp[pos++] = arr[pos2++];
        }
        if (pos1 > mid)
            while (pos2 <= high)
                tmp[pos++] = arr[pos2++];
        else
            while (pos1 <= mid)
                tmp[pos++] = arr[pos1++];
        for (int i = 0; i < tmp.length; i++)
            arr[low + i] = tmp[i];
    }
}
