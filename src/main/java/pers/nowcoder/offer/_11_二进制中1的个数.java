package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 思路:对给定的数做无符号位移运行算,无符号位移最高位用0补齐.每次位移后取左边第一位数进行判断
 */
public class _11_二进制中1的个数
{
    public int NumberOf1(int n)
    {
        int res = 0;
        while (n != 0)
        {
            //取最左边第一位数
            int temp = n & 1;
            if (temp == 1)
                res++;
            //无符号位移运算
            n = n >>> 1;
        }
        return res;
    }
}
