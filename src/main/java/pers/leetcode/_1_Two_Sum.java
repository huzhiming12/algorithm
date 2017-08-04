package pers.leetcode;

import java.util.HashMap;

/**
 * Created by huzhiming on 2017/8/3.
 * Description:给定一组整数，将两个数的返回指数相加，使它们相加成一个特定的目标。
 * 您可以假设每个输入都有一个解决方案，
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 思路:如果用暴力方法的话时间复杂度是O(n^2),会超时
 * 应该用HashMap作为辅助,只需一次遍历数组即可,时间复杂度是O(n)
 */
public class _1_Two_Sum
{
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                int[] res = {map.get(nums[i]), i};
                return res;
            } else
            {   //如果Map中不包含这个数,则将target与其的差值放入Map中
                int tmp = target - nums[i];
                map.put(tmp, i);
            }
        }
        return null;
    }
}
