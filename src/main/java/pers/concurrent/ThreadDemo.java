package pers.concurrent;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by huzhiming on 2017/7/17.
 * Description:
 */
public class ThreadDemo
{
    public static void main(String[] args)
    {
        Thread thread = new Thread(new MyRunnable1());
        thread.start();
        thread.interrupt();
    }
}

class MyRunnable1 implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


