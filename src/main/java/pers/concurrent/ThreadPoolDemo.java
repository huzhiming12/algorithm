package pers.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by huzhiming on 2017/7/12.
 * Description:
 */
public class ThreadPoolDemo
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 20; i++)
        {
            executor.execute(new MyRunable(i));
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}

class MyRunable implements Runnable
{
    int id;

    public MyRunable(int id)
    {
        this.id = id;
    }

    @Override
    public void run()
    {
        System.out.println("task:" + id + " threadName:" + Thread.currentThread().getName());
        try
        {
            Thread.sleep(200);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
