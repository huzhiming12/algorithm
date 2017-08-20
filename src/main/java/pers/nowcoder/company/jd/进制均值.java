package pers.nowcoder.company.jd;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/17.
 * Description:
 */
public class 进制均值
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int A = in.nextInt();
            int res = 0;
            for (int i = 2; i < A; i++)
                res += sumOfNum(A, i);
            int num1 = res;
            int num2 = A - 2;
            while (num1 % num2 != 0)
            {
                int tmp = num1 % num2;
                num1 = num2;
                num2 = tmp;
            }
            System.out.println(res / num2 + "/" + (A - 2) / num2);
        }
    }

    static int sumOfNum(int num, int K)
    {
        int res = 0;
        while (num != 0)
        {
            res += num % K;
            num = num / K;
        }
        return res;
    }
}
