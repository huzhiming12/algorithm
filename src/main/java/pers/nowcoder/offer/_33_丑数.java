package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/13.
 * Description:
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 *
 */
public class _33_丑数
{
    public int GetUglyNumber_Solution(int index)
    {
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        int min2 = 0;
        int min3 = 0;
        int min5 = 0;
        int pos = 1;
        while (pos < index)
        {
            int min = getMinNum(uglyNum[min2] * 2, uglyNum[min3] * 3, uglyNum[min5] * 5);
            if (min == uglyNum[min2] * 2)
                min2++;
            if (min == uglyNum[min3] * 3)
                min3++;
            if (min == uglyNum[min5] * 5)
                min5++;
            uglyNum[pos++] = min;
        }
        return uglyNum[index - 1];
    }

    public int getMinNum(int num1, int num2, int num3)
    {
        int temp = Math.min(num1, num2);
        return Math.min(temp, num3);
    }
}
