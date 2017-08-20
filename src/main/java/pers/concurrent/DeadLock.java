package pers.concurrent;

/**
 * Created by huzhiming on 2017/8/18.
 * Description:
 */
public class DeadLock extends Thread
{
    static int a, b;

    public DeadLock(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run()
    {
        super.run();
        synchronized (Integer.valueOf(a))
        {
            synchronized (Integer.valueOf(b))
            {
                System.out.println(Thread.currentThread().getName() + " a:" + a + " b:" + b);
            }
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 1000; i++)
        {
            new DeadLock(1, 2).start();
            new DeadLock(2, 1).start();
        }
    }
}
