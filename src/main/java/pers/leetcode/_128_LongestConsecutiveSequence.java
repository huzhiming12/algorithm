package pers.leetcode;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by huzhiming on 2017/8/3.
 * Description:
 * 给定一个未排序整数的数组，找到最长连续元素序列的长度。
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * 思路:题目要求时间复杂度是O(n),故不能对数组先排序.
 * 可以通过Hash表对所有出现的数字进行存储,然后对每个元素进行左右扩张遍历
 */
public class _128_LongestConsecutiveSequence
{
    public int longestConsecutive(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        Iterator it = set.iterator();
        int max = 0;
        //记录已经遍历过的数据
        HashSet<Integer> done = new HashSet<>();
        while (it.hasNext())
        {
            Integer num = (Integer) it.next();
            if (done.contains(num))
                continue;
            done.add(num);
            int res = 1;
            int pos = num + 1;
            //向右边扩展
            while (set.contains(pos))
            {
                done.add(pos);
                res++;
                pos++;
            }
            pos = num - 1;
            //向左边扩展
            while (set.contains(pos))
            {
                done.add(pos);
                res++;
                pos--;
            }
            max = max > res ? max : res;
        }
        return max;
    }

    //
    public int longestConsecutive1(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int max = 0;
        for (int num : nums)
        {
            int res = 1;
            int pos = num + 1;
            while (set.contains(pos))
            {
                set.remove(pos);
                res++;
                pos++;
            }
            pos = num - 1;
            while (set.contains(pos))
            {
                set.remove(pos);
                res++;
                pos--;
            }
            set.remove(num);
            max = max > res ? max : res;
        }
        return max;
    }
}
