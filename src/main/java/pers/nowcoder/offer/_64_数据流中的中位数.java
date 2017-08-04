package pers.nowcoder.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class _64_数据流中的中位数
{
    private Queue<Integer> max = new PriorityQueue<>();
    private Queue<Integer> min = new PriorityQueue<Integer>(20, new Comparator<Integer>()
    {
        @Override
        public int compare(Integer o1, Integer o2)
        {
            return o2 - o1;
        }
    });
    private int length = 0;

    public void Insert(Integer num)
    {
        if (length == 0)
            min.add(num);
        else
        {
            //加入min
            if (length % 2 == 0)
            {
                if (max.peek() < num)
                {
                    int top = max.remove();
                    max.add(num);
                    min.add(top);
                } else
                    min.add(num);
            } else
            {
                //加入Max
                if (min.peek() > num)
                {
                    int top = min.remove();
                    max.add(top);
                    min.add(num);
                } else
                    max.add(num);
            }
        }
        length++;
    }

    public Double GetMedian()
    {
        if (length == 0)
            return null;
        if (length % 2 == 1)
            return min.peek() / 1.0;
        return (min.peek() + max.peek()) / 2.0;
    }

    public static void main(String[] args)
    {
        _64_数据流中的中位数 demo = new _64_数据流中的中位数();
        int[] arr = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < arr.length; i++)
        {
            demo.Insert(arr[i]);
            System.out.println(demo.GetMedian());
        }
    }
}
