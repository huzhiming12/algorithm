package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/7/8.
 * Description:
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 思路:
 * 1.直接调用String函数替换空格
 * 2.用StringBuffer构造新字符串,遍历String,遇到空格替换
 * 3.String转成char数组,计算空格个数,计算替换完成之后字符总数,从最后位置往前方字符串
 */
public class _2_替换空格
{
    public String replaceSpace(StringBuffer str)
    {
        String res = str.toString();
        return res.replace(" ", "%20");
    }
}
