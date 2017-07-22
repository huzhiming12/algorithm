package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * <p>
 * 思路:
 * 将数组中全部元素进行异或运算,最后得出的结果只包含两个只出现一次的数的异或结果.
 * 从这个结果中,按位找第一位为1的位置,则这两个数在这个位置上的值肯定不一样.这样可通过这一位置上的值
 * 将数组分成两拨.
 */
public class _40_数组中只出现一次的数字
{
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[])
    {
        int temp = array[0];
        for (int i = 1; i < array.length; i++)
        {
            temp = temp ^ array[i];
        }

        int k = 0;
        //找出第一位不为0的位置K
        while (temp != 0)
        {
            if ((temp & 1) == 1)
                break;
            k++;
            temp = temp >> 1;
        }

        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++)
        {
            //通过第k位上的值将数组分成两拨
            int a = (array[i] >> k) & 1;
            if (a == 0)
                num1[0] = num1[0] ^ array[i];
            else
                num2[0] = num2[0] ^ array[i];
        }
    }
}
