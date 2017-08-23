package pers;

/**
 * Created by huzhiming on 2017/8/23.
 * Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        int i = 0;
        Integer i1 = 0;
        Integer i2 = new Integer(0);
        Integer i3 = 0;
        System.out.println(i == i1);
        System.out.println(i == i2);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
    }
}

class A
{
    protected A test()
    {
        return null;
    }
}

class B extends A
{
    public B test()
    {
        return null;
    }
}
