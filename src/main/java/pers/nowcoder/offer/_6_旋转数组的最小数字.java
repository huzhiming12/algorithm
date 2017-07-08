package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 思路:二分查找法,中间值array[mid]大于两边值  则说明mid 在左边的递增序列上,则左边界向中间移动
 * 否则说明 mid 在右边的递增序列上,右边界向中间移动.
 * 当左边界和右边界相邻时,可能出现中间值一直是左边界,因此需要单独判断一下.
 *
 */
public class _6_旋转数组的最小数字
{
    public static int minNumberInRotateArray(int[] array)
    {
        if (array == null || array.length == 0)
            return 0;

        int low = 0;
        int high = array.length - 1;
        while (array[low] >= array[high])
        {
            //左右边界相邻,则右边是最小值,左边界是最大值
            if (low + 1 == high)
                return array[high];
            int mid = low + (high - low) / 2;
            //如果中间值大于左右边界,左边界移动
            if (array[mid] >= array[low] && array[mid] >= array[high])
                low = mid;
            else
                high = mid;
        }
        return array[high];
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 5, 6, 7, 1, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
