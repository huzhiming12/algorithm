package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/2.
 * Description:
 */
public class _35_Search_Insert_Position
{
    public int searchInsert(int[] A, int target)
    {
        int low = 0, high = A.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
