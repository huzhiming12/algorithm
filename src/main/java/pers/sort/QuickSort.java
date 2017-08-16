package pers.sort;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 */
public class QuickSort
{
    public static void main(String[] args)
    {
        int[] arr = {7, 2, 1, 5, 8, 10, -4, 5, 19, -65};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high)
    {
        int mid = partition(arr, low, high);
        if (low < mid - 1)
            quickSort(arr, low, mid - 1);
        if (mid + 1 < high)
            quickSort(arr, mid + 1, high);
    }

    public static int partition(int[] arr, int low, int high)
    {
        int value = arr[low];
        while (low < high)
        {
            while (low < high && arr[high] >= value)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= value)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = value;
        return low;
    }
}
