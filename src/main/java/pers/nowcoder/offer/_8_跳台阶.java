package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 思路:
 * f(n)表示从0阶跳到n阶有f(n)种跳法,因为一次只能跳一阶或者两阶,故f(n)=f(n-1)+f(n-2)
 * 类似一个斐波那契数列
 */
public class _8_跳台阶
{
    public int JumpFloor(int target)
    {
        if (target == 0)
            return 0;
        int[] jumps = new int[target + 1];
        jumps[1] = jumps[0] = 1;
        for (int i = 2; i <= target; i++)
        {
            jumps[i] = jumps[i - 1] + jumps[i - 2];
        }
        return jumps[target];
    }
}
