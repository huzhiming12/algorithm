package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 思路: 数组从左到右递增,从上到下也是递增的,可以从数组的左下角开始查找
 * 如果当前数组的值比要查找的值小,则往右移;
 * 如果当前数组的值比要查找的值大,则往上移动;
 * 当前所在位置越界则说明不在这个值
 */
public class _1_二维数组中的查找
{
    public boolean Find(int target, int[][] array)
    {
        int x = array.length - 1;
        int y = 0;
        while (x >= 0 && y < array[x].length)
        {
            if (array[x][y] > target)
                x--;
            else if (array[x][y] < target)
                y++;
            else
                return true;
        }
        return false;
    }
}
