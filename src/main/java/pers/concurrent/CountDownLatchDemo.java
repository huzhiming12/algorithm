package pers.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by huzhiming on 2017/8/16.
 * Description:
 */
public class CountDownLatchDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker(latch);
        worker1.start();
        Worker worker2 = new Worker(latch);
        worker2.start();
        Worker worker3 = new Worker(latch);
        worker3.start();
        latch.await();
        System.out.println("works is over, begin Main Work!");
    }
}

class Worker extends Thread
{
    private CountDownLatch latch;

    public Worker(CountDownLatch latch)
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        super.run();
        System.out.println(Thread.currentThread().getName() + " begin work!");
        try
        {
            sleep(new Random().nextInt(10000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " work over!");
        latch.countDown();
    }
}
