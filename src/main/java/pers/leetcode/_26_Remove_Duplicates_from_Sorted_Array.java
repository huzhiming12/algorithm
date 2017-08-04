package pers.leetcode;

import java.util.Arrays;

/**
 * Created by huzhiming on 2017/8/2.
 * Description: 移除数组中重复的元素,返回剩余数组的大小
 */
public class _26_Remove_Duplicates_from_Sorted_Array
{
    public static int removeDuplicates(int[] nums)
    {
        if (nums == null || nums.length < 1)
            return 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++)
        {
            //index 存放的是第一个不等于index-1的数
            if (nums[index - 1] != nums[i])
                nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 3, 4, 4};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
