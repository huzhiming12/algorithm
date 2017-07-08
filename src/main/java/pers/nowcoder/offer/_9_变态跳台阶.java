package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 思路:一次可以跳1\2\3\4……\n 故 f(n)=f(n-1)+f(n-2)+……+f(1);
 */
public class _9_变态跳台阶
{
    public int JumpFloorII(int target)
    {
        if (target == 0)
            return 0;

        int[] jumps = new int[target + 1];
        jumps[0] = jumps[1] = 1;
        for (int i = 2; i <= target; i++)
        {
            for (int j = 0; j < i; j++)
                jumps[i] += jumps[j];
        }
        return jumps[target];
    }
}
