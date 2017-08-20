package pers.nowcoder.company.jd;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by huzhiming on 2017/8/17.
 * Description:
 */
public class 集合
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int m = in.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++)
                set.add(in.nextInt());
            for (int i = 0; i < m; i++)
                set.add(in.nextInt());
            Iterator it = set.iterator();
            while (it.hasNext())
            {
                Integer num = (Integer) it.next();
                System.out.print(num);
                if (it.hasNext())
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
    }
}
