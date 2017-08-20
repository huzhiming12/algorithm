package pers.nowcoder.company.jd;

/**
 * Created by huzhiming on 2017/8/18.
 * Description:
 */
public class Test
{
}

class Singleton
{
    private static Singleton obj = new Singleton();
    public static int counter1;
    public static int counter2 = 0;

    private Singleton()
    {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance()
    {
        return obj;
    }
}

class MyMain
{
    public static void main(String[] args)
    {
        Singleton obj = Singleton.getInstance();
        System.out.println("obj.counter1==" + obj.counter1);
        System.out.println("obj.counter2==" + obj.counter2);
    }
}