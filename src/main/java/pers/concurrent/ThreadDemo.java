package pers.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static javafx.scene.input.KeyCode.F;
import static javafx.scene.input.KeyCode.T;

/**
 * Created by huzhiming on 2017/7/17.
 * Description:
 */
public class ThreadDemo
{
    public static void main(String[] args) throws Exception
    {
        Thread thread = new Thread(new MyRunnable1());
        thread.start();
        thread.interrupt();

        new MyThread().start();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}

//创建线程方式一:继承Thread类
class MyThread extends Thread
{
    @Override
    public void run()
    {
        super.run();
        System.out.println("开启线程");
    }
}

//创建线程方式二:实现runnable接口
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

//方式三:通过Callable实现
class MyCallable implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("调用call方法创建线程");
        return 1;
    }
}


