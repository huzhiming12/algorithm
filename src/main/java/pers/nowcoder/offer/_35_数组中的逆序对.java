package pers.nowcoder.offer;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/7/17.
 * Description:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入
 * <p>
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 *
 * 思路:通过归并排序找出每个数移动的位置个数
 */
public class _35_数组中的逆序对
{
    long res = 0;

    public int InversePairs(int[] array)
    {
        mergeSort(array, 0, array.length - 1);
        return (int) (res % 1000000007);
    }

    public void mergeSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int mid = (low + high) / 2;
            if (low < mid)
                mergeSort(arr, low, mid);
            if (mid + 1 < high)
                mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high)
    {
        int[] tempArr = new int[high - low + 1];
        int p1 = low, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= high)
        {
            if (arr[p1] <= arr[p2])
            {
                tempArr[p++] = arr[p1++];
            } else
            {
                tempArr[p++] = arr[p2++];
                res += mid - p1 + 1;
            }
        }
        if (p1 > mid)
        {
            while (p2 <= high)
                tempArr[p++] = arr[p2++];
        } else
        {
            while (p1 <= mid)
                tempArr[p++] = arr[p1++];
        }
        for (int i = low; i <= high; i++)
            arr[i] = tempArr[i - low];
    }

    public static void main(String[] args)
    {
        _35_数组中的逆序对 demo = new _35_数组中的逆序对();
        int[] arr = {5, 3, 4, 1, 6, 9};
        System.out.println(demo.InversePairs(arr));
        System.out.println(Arrays.toString(arr));
    }
}
