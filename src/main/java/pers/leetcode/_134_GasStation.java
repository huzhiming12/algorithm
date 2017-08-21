package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/20.
 * Description:
 * There are N gas stations along a circular route, where the amount
 * of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of
 * gas to travel from station i to its next station (i+1). You begin the
 * journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around
 * the circuit once, otherwise return -1.
 */
public class _134_GasStation
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int sum = 0;
        int total = 0;
        //res 表示出发的结点
        int res = 0;
        for (int i = 0; i < gas.length; i++)
        {
            //sum表示除去消耗剩余的汽油
            sum += gas[i] - cost[i];
            if (sum < 0)
            {
                //如果剩余值为负数,则记下这个负值,然后从下一个结点出发
                total += sum;
                sum = 0;
                //从下一个结点出发
                res = i + 1;
            }
        }
        total += sum;
        return total < 0 ? -1 : res;
    }
}
