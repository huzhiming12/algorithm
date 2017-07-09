package pers.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by huzhiming on 2017/7/9.
 * Description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 思路:记录下数组中第一次出现偶数的位置.遍历的时候只要是奇数,并且前面有偶数时,
 * 将当前奇数与到偶数之间的所有数都交换位置
 * 例如:1,3,4,6,8,9
 * 第一个偶数是 4, 遍历到9时 将9 与4-8这些数都交换一遍
 */
public class _13_调整数组顺序使奇数位于偶数前面
{
    public static void reOrderArray(int[] array)
    {
        //记录下当前第一个偶数出现的位置
        int pos = -1;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] % 2 == 0 && pos == -1)
                pos = i;
                //如果当前数是奇数,并且其前面有偶数,则依次将array[i]与pos到i-1位置上的数交换位置
            else if (array[i] % 2 == 1 && pos != -1)
            {
                for (int j = i; j > pos; j--)
                {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                //偶数位置向后移动一位
                pos++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 4, 3, 5, 2, 8, 9, 7};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
