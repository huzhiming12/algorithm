package pers.nowcoder.offer;

import java.util.ArrayList;

/**
 * Created by huzhiming on 2017/7/10.
 * Description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路:xBegin yBegin表示横坐标和纵坐标起始位置,
 * xEnd yEnd表示横坐标和纵坐标的终点位置
 */
public class _19_顺时针打印矩阵
{
    public ArrayList<Integer> printMatrix(int[][] matrix)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null)
            return res;
        int xBegin = 0;
        int yBegin = 0;
        int xEnd = matrix.length - 1;
        int yEnd = matrix[0].length - 1;
        while (xBegin <= xEnd && yBegin <= yEnd)
        {
            //第一行从左到右
            for (int y = yBegin; y <= yEnd; y++)
                res.add(matrix[xBegin][y]);
            //最后一列从上到下
            for (int x = xBegin + 1; x <= xEnd; x++)
                res.add(matrix[x][yEnd]);
            //最后一行从右到左遍历
            for (int y = yEnd - 1; y >= yBegin && xEnd - xBegin >= 1; y--)
                res.add(matrix[xEnd][y]);
            //第一列从下到上
            for (int x = xEnd - 1; x > xBegin && yEnd - yBegin >= 1; x--)
                res.add(matrix[x][yBegin]);
            xBegin++;
            yBegin++;
            xEnd--;
            yEnd--;
        }
        return res;
    }
}
