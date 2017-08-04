package pers.leetcode;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class _10_RegularExpressionMatching
{
    public static boolean isMatch(String s, String p)
    {
        return match(s, p, 0, 0);
    }

    public static boolean match(String s, String p, int pos1, int pos2)
    {
        if (pos1 >= s.length() && pos2 >= p.length())
            return true;
        if (pos1 < s.length() && pos2 >= p.length())
            return false;
        //如果第二个字符时*
        if (pos2 + 1 < p.length() && p.charAt(pos2 + 1) == '*')
        {
            //s 还有字符串
            if (pos1 < s.length())
            {
                //如果 p.pos1 == p.pos2  或者 p.pos =='.'
                //则可以匹配 0,1和多个字符,否则只能匹配一个字符
                if ((s.charAt(pos1) == p.charAt(pos2) || p.charAt(pos2) == '.'))
                    return match(s, p, pos1, pos2 + 2)  //匹配0个字符
                            || match(s, p, pos1 + 1, pos2 + 2) //匹配1个字符
                            || match(s, p, pos1 + 1, pos2);//匹配多个字符
                else
                    return match(s, p, pos1, pos2 + 2);  //匹配 0个字符
            } else //s没有字符串了,*zi能匹配1个字符
                return match(s, p, pos1 + 1, pos2 + 2); //匹配1个字符
        }

        //pos1没有超出限制, s.pos1==p.pos2 或者p.pos2 =="."
        if (pos1 < s.length() && (s.charAt(pos1) == p.charAt(pos2) || p.charAt(pos2) == '.'))
            return match(s, p, pos1 + 1, pos2 + 1);
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(isMatch("a", ".*..a*"));
    }
}
