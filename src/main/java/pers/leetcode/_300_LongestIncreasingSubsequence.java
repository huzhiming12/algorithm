package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for
 * you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class _300_LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums)
    {
        if(nums==null||nums.length==0)
            return 0;
        int res = 0;
        int[] h = new int[nums.length];
        h[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            int max = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j] && max <= h[j])
                    max = h[j] + 1;
            h[i] = max;
        }
        res = h[0];
        for (int i = 1; i < nums.length; i++)
            res = Math.max(res, h[i]);
        return res;
    }
}
