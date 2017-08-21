package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/21.
 * Description:
 * 判读数字是否是回文数字,不使用额外空间
 */
public class _9_PalindromeNumber
{
    public static boolean isPalindrome(int x)
    {
        if (x<0)
            return false;
        int len = 1;
        int num = x;
        while (num != 0)
        {
            num /= 10;
            if (num != 0)
                len *= 10;
        }
        int num1 = x, num2 = x;
        while (num1 != 0 && num2 != 0)
        {
            int x1 = num1 / len;
            int x2 = num2 % 10;
            if (x1 != x2)
                return false;
            num1 = num1 - x1 * len;
            len /= 10;
            num2 /= 10;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome(1000000001));
    }
}
