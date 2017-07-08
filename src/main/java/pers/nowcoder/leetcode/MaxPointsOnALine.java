package pers.nowcoder.leetcode;

import pers.nowcoder.entity.Point;

import java.util.HashMap;

/**
 * Created by huzhiming on 2017/6/17.
 * Description:
 * <p>
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 * 找出最多共线的点的个数
 */


public class MaxPointsOnALine
{
    public int maxPoints(Point[] points)
    {
        int len = points.length;
        if (len < 2)
            return len;
        int res = 0;
        for (int i = 0; i < len - 1; i++)
        {
            HashMap<Double, Integer> map = new HashMap<>();
            int repeatNum = 0;
            int verticalNum = 0;
            int max = 1;
            for (int j = i + 1; j < len; j++)
            {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;

                if (x == 0 && y == 0)
                    repeatNum++;
                else if (x == 0)//垂直
                {
                    if (verticalNum == 0)
                        verticalNum = 2;
                    else
                        verticalNum++;
                    max = Math.max(verticalNum, max);
                } else
                {
                    // 会产生-0.0 现象,所以加上0.0
                    double k = y * 1.0 / x + 0.0f;
                    if (map.containsKey(k))
                        map.put(k, map.get(k) + 1);
                    else
                        map.put(k, 2);
                    max = Math.max(map.get(k), max);
                }
            }

            res = Math.max(max + repeatNum, res);
        }
        return res;
    }

    public static void main(String[] args)
    {
        Point[] points = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }
}
