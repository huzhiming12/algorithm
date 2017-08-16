package pers.leetcode;

import java.util.List;

/**
 * Created by huzhiming on 2017/8/11.
 * Description:
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class _120_Triangle
{
    /**
     * 思路:从后往前计算
     */
    public int minimumTotal(List<List<Integer>> triangle)
    {
        for (int i = triangle.size() - 2; i >= 0; i--)
        {
            for (int j = 0; j < triangle.get(i).size(); j++)
            {
                int minValue = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, minValue);
            }
        }
        return triangle.get(0).get(0);
    }
}
