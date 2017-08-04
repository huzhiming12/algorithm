package pers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huzhiming on 2017/8/3.
 * Description:给定n个整数的数组s，s中有a、b、c这样的a + b＝c＝0吗？查找数组中所有唯一的三胞胎，给出零和。
 * S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 思路:先对数组进行排序,然后遍历时先固定一个值,另外两个值分别在最左端和最右端向中间逼近
 */
public class _15_3Sum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = 0 - nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high)
            {
                int tempSum = nums[low] + nums[high];
                if (tempSum < target)
                {
                    low++;
                    while (low <= high && nums[low] == nums[low - 1])
                        low++;
                } else if (tempSum > target)
                {
                    high--;
                    while (low <= high && nums[high] == nums[high + 1])
                        high--;
                } else
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    res.add(list);
                    low++;
                    while (low <= high && nums[low] == nums[low - 1])
                        low++;
                }
            }
        }
        return res;
    }
}
