package pers.nowcoder.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;

/**
 * Created by huzhiming on 2017/7/13.
 * Description:
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 思路: 对数组进行排序,排序规则如下:
 * 两个数从高位开始按位进行比较,小的排在前面.位数较少的用高位补齐.
 * 如:  34521 与 34比较.  由于34位数较少,所以用高位补齐,即:
 * =     34521
 * =     34343 比较这两个数即可
 */
public class _32_把数组排成最小的数
{
    public static String PrintMinNumber(int[] numbers)
    {
        StringBuffer buffer = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numbers)
            list.add(num);
        Collections.sort(list, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                String str1 = o1.toString();
                String str2 = o2.toString();
                int pos1 = 0;
                int pos2 = 0;
                while (true)
                {
                    if (pos1 >= str1.length() && pos2 >= str2.length())
                        break;
                    //位数不够,则再从高位开始比较
                    if (str1.charAt(pos1 % str1.length()) > str2.charAt(pos2 % str2.length()))
                        return 1;
                    else if (str1.charAt(pos1 % str1.length()) < str2.charAt(pos2 % str2.length()))
                        return -1;
                    else
                    {
                        pos1++;
                        pos2++;
                    }
                }
                return 0;
            }
        });
        for (int num : list)
            buffer.append(num);
        return buffer.toString();
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 32, 321};
        System.out.println(PrintMinNumber(arr));
    }
}
