package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/13.
 * Description:
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 *
 * 思路:因为字符串中只有字母,故定义一个长度为52的int数组,记录每个字母第一次出现的位置,
 * 小写字母放在前面,大写字母放在后面.遍历字符串时,如果字母没有出现过,则对应位置上应该是0,将其改为
 * 对应的位置(位置从1开始);如果字母出现过,则对应位置上应该不为0,将其改成-1,表示出现过多次.
 * 最后在int数组中找到大于0的数中的最小值,这就是要求的结果
 */
public class _34_第一个只出现一次的字符
{
    public int FirstNotRepeatingChar(String str)
    {
        if ("".equals(str))
            return -1;
        int[] arr = new int[52];
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            int pos = 0;
            if (c >= 'a' && c <= 'z')
                pos = c - 'a';
            if (c >= 'A' && c <= 'Z')
                pos = c - 'A' + 26;
            //字符第一次出现,则记录它出现的位置
            if (arr[pos] == 0)
                arr[pos] = i + 1;
            //字母已经出现过
            else
                arr[pos] = -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 0 && arr[i] < min)
                min = arr[i];
        }
        return min - 1;
    }
}
