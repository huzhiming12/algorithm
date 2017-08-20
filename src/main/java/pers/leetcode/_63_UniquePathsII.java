package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/19.
 * Description:
 * 题意:二维数组,1表示不能通过,0表示可以通过,就求从左上角到右下角有多少种走法
 */
public class _63_UniquePathsII
{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        dp[0][0] = 1;
        for (int i = 1; i < m; i++)
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1)
                dp[i][0] = 1;
        for (int i = 1; i < n; i++)
            if (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1)
                dp[0][i] = 1;

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                //如果当前位置是1的话,那么dp 直接就是0了
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        int[][] arr = {{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
