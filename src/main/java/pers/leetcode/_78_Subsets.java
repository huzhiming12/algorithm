package pers.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huzhiming on 2017/8/21.
 * Description:
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class _78_Subsets
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        for (int num : nums)
        {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> a : res)
            {
                List<Integer> list = new ArrayList<>(a);
                list.add(num);
                tmp.add(list);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
