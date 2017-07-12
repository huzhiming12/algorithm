package pers.nowcoder.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.JarEntry;

/**
 * Created by huzhiming on 2017/7/12.
 * Description:
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * <p>
 * 思路:
 * 1.快排思想,每次选的轴的位置如果小于k,则继续排序右边部分;如果大于k则排序左边部分;直到partition返回值等于k
 * 2.构造元素个数是k的极大堆,当新加的元素小于堆顶的时候,删除堆顶元素,重新构造堆,直到所有元素都遍历结束,最后堆中元素就是结果
 */
public class _29_最小的K个数
{
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k || k == 0)
            return res;
        quickSort(input, 0, input.length - 1, k - 1);
        for (int i = 0; i < k; i++)
            res.add(input[i]);
        Collections.sort(res);
        return res;
    }

    //方法一:运用快排思想
    public void quickSort(int[] arr, int low, int high, int k)
    {
        int pos = partition(arr, low, high);
        if (pos < k)
            quickSort(arr, pos + 1, high, k);
        else if (pos > k)
            quickSort(arr, low, pos - 1, k);
        else
            return;
    }

    public int partition(int[] arr, int low, int high)
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

    //方法二:运用堆排序的思想

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k || k == 0)
            return res;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = input[i];
        heapSort(arr);
        for (int i = k; i < input.length; i++)
        {
            if (arr[0] > input[i])
            {
                arr[0] = input[i];
                adjustHeap(arr, 0);
            }
        }

        for (int i = 0; i < k; i++)
            res.add(arr[i]);
        Collections.sort(res);
        return res;
    }

    //构造极大堆
    public void heapSort(int arr[])
    {
        for (int i = arr.length / 2; i >= 0; i--)
            adjustHeap(arr, i);
    }

    public void adjustHeap(int[] arr, int k)
    {
        int src = arr[k];
        for (int i = k * 2 + 1; i < arr.length; i = k * 2 + 1)
        {
            //如果左结点小于右结点,则让i=右结点编号,即i始终在较大结点处
            if (i + 1 < arr.length && arr[i] < arr[i + 1])
                i++;
            //如果根节点大于两个子节点,则直接退出
            if (src > arr[i])
                break;
            //将大的叶子结点挪到根节点处
            arr[k] = arr[i];
            k = i;
        }
        arr[k] = src;
    }


    public static void main(String[] args)
    {
        int[] arr = {3, 1, 2, 4, 8, 5, 7, 6};
        _29_最小的K个数 demo = new _29_最小的K个数();
        System.out.println(demo.GetLeastNumbers_Solution2(arr, 5));
    }
}
