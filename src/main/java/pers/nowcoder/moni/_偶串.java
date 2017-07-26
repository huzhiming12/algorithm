package pers.nowcoder.moni;

import java.util.Scanner;

/**
 * Created by huzhiming on 2017/7/25.
 * Description:
 */
public class _偶串
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            String str = in.nextLine();
            for (int i = 1; i * 2 <= str.length(); i++)
            {
                int len = (str.length() - i * 2) / 2;
                String sub1 = str.substring(0, len);
                String sub2 = str.substring(len, len * 2);
                if (sub1.equals(sub2))
                {
                    System.out.println(len * 2);
                    break;
                }
            }
        }
    }
}
