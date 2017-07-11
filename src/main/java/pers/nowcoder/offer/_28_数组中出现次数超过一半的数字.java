package pers.nowcoder.offer;

import java.util.HashMap;

/**
 * Created by huzhiming on 2017/7/11.
 * Description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * <p>
 * 思路:用hashMap记录下每个数字出现的次数.
 */
public class _28_数组中出现次数超过一半的数字
{
    public int MoreThanHalfNum_Solution(int[] array)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++)
        {
            int value = 1;
            if (map.containsKey(array[i]))
            {
                value = map.get(array[i]);
                value++;
            }
            map.put(array[i], value);
            if (value > array.length / 2)
                return array[i];
        }
        return 0;
    }


    //如果有一个数出现的次数超过一半,
    // 要么这个数会连续出现,  如 1,2,2,2,1
    // 要么最后一个元素肯定是这个数 2,1,2,1,2
    public static int MoreThanHalfNum_Solution1(int[] numbers)
    {
        int n = numbers.length;
        if (n == 0) return 0;

        int num = numbers[0], count = 1;
        for (int i = 1; i < n; i++)
        {
            if (numbers[i] == num) count++;
            else count--;
            if (count == 0)
            {
                num = numbers[i];
                count = 1;
            }
        }
        // Verifying
        count = 0;
        for (int i = 0; i < n; i++)
        {
            if (numbers[i] == num) count++;
        }
        if (count * 2 > n) return num;
        return 0;
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 2, 3, 3, 2};
        System.out.println(MoreThanHalfNum_Solution1(arr));
    }
}
