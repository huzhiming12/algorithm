package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
public class _11_ContainerWithMostWater
{
    public int maxArea(int[] height)
    {
        int low = 0;
        int high = height.length - 1;
        int max = 0;
        while (low < high)
        {
            int temp = (high - low) * Math.min(height[low], height[high]);
            max = Math.max(temp, max);
            if (height[high] > height[low])
                low++;
            else
                high--;
        }
        return max;
    }
}
