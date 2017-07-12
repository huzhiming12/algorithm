package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/12.
 * Description:
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
 * 是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 * <p>
 * 思路:用tempsum记录和前缀,用max记录最大的和前缀,如果tempsum<0则清0,
 */
public class _30_连续子数组的最大和
{
    public static int FindGreatestSumOfSubArray(int[] array)
    {
        int max = array[0];
        int tempSum = array[0];
        for (int i = 1; i < array.length; i++)
        {
            tempSum += array[i];
            if (max < tempSum)
                max = tempSum;
            //前缀小于0,则重新计算
            if (tempSum < 0)
                tempSum = 0;
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
