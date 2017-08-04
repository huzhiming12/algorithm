package pers.nowcoder.offer;

import java.util.LinkedList;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class _55_字符流中第一个不重复的字符
{
    LinkedList<Character> queue = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (queue.contains(ch))
            queue.remove(ch);
        else queue.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (queue.isEmpty())
            return '#';
        else
            return queue.getFirst();
    }
}
