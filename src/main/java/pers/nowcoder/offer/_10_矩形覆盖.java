package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 思路:f(n)表示n个2*1的大矩形有f(n)覆盖方法
 * f(n)=f(n-1)+f(n-2)  f(n-1):最后一个矩形是竖着摆放的,剩下的n-1个矩形暂时不考虑
 * f(n-2):最后两个是矩形是横着摆放,剩下n-2个矩形暂时不考虑
 */
public class _10_矩形覆盖
{
    public int RectCover(int target)
    {
        if (target <= 2)
            return target;
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
