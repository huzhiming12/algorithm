package pers.leetcode.contest46;

/**
 * Created by huzhiming on 2017/8/20.
 * Description:
 */
public class _661_ImageSmoother
{
    public int[][] imageSmoother(int[][] M)
    {
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int sum = M[i][j];
                int num = 1;
                if (i - 1 >= 0)
                {
                    num++;
                    sum += M[i - 1][j];
                    if (j - 1 >= 0)
                    {
                        num++;
                        sum += M[i - 1][j - 1];
                    }
                    if (j + 1 < n)
                    {
                        num++;
                        sum += M[i - 1][j + 1];
                    }
                }
                if (i + 1 < m)
                {
                    num++;
                    sum += M[i + 1][j];
                    if (j - 1 >= 0)
                    {
                        num++;
                        sum += M[i + 1][j - 1];
                    }
                    if (j + 1 < n)
                    {
                        num++;
                        sum += M[i + 1][j + 1];
                    }
                }
                if (j - 1 >= 0)
                {
                    num++;
                    sum += M[i][j - 1];
                }
                if (j + 1 < n)
                {
                    num++;
                    sum += M[i][j + 1];
                }
                res[i][j] = (int) Math.floor(sum * 1.0 / num);
            }
        }
        return res;
    }
}
