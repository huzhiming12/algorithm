package pers.sort;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * Created by huzhiming on 2017/6/17.
 * Description:
 */
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr = {3, 5, 1, 5, 2, 6, 8, 3, 5, 7};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    //将两个有序的数组合并成一个有序数组
    public static void merge(int[] arr, int low, int mid, int high)
    {
        int[] temp = new int[high - low + 1];
        int l = low, r = mid + 1;
        int i = 0;
        while (l <= mid && r <= high)
        {
            if (arr[l] < arr[r])
                temp[i++] = arr[l++];
            else
                temp[i++] = arr[r++];
        }
        if (l > mid)
            while (r <= high)
                temp[i++] = arr[r++];
        else
            while (l <= mid)
                temp[i++] = arr[l++];
        for (i = low; i <= high; i++)
            arr[i] = temp[i - low];
    }
}
