package pers.nowcoder.company.pdd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by huzhiming on 2017/8/1.
 * Description: 大整数相乘
 */
public class Main2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        String num1 = str[0];
        String num2 = str[1];
        System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < num1.length(); i++)
        {
            int n1 = num1.charAt(num1.length() - 1 - i) - '0';
            StringBuilder builder = new StringBuilder();
            for (int m = 0; m < i; m++)
                builder.append("0");

            //表示进位
            int k = 0;
            for (int j = 0; j < num2.length(); j++)
            {
                int n2 = num2.charAt(num2.length() - 1 - j) - '0';
                int temp = n1 * n2;
                temp += k;
                builder.append(temp % 10);
                k = temp / 10;
            }
            if (k != 0)
                builder.append(k);
            list.add(builder.toString());
        }

        String string = list.get(0);
        for (int i = 1; i < list.size(); i++)
        {
            StringBuilder builder = new StringBuilder();
            String str1 = list.get(i);
            int k = 0;
            int pos = 0;
            while (pos < str1.length() || pos < string.length())
            {
                int n1 = pos >= str1.length() ? 0 : str1.charAt(pos) - '0';
                int n2 = pos >= string.length() ? 0 : string.charAt(pos) - '0';
                int sum = n1 + n2 + k;
                builder.append(sum % 10);
                k = sum / 10;
                pos++;
            }
            if (k != 0)
                builder.append(k);
            string = builder.toString();
        }
        for (int i = string.length() - 1; i >= 0; i--)
            System.out.print(string.charAt(i));
        System.out.println();
    }
}
