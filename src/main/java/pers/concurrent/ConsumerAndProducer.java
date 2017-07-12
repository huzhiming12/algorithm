package pers.concurrent;

import java.util.Random;

/**
 * Created by huzhiming on 2017/7/12.
 * Description: 模拟生产者消费者模式
 */
public class ConsumerAndProducer
{
    int len = 10;
    //模拟的缓冲区,用于存放生产的商品
    int[] buffer = new int[len];

    //in 表示生产放的位置, out表示即将消费的位置
    int in = 0, out = 0;
    //缓冲区中剩下的商品数量
    Integer remain = 0;
    //即将生产的产品编号
    int productId = 0;

    //生产产品
    public void produce()
    {
        if (remain < len)
            synchronized (remain)
            {
                if (remain < len)
                {
                    //剩下产品数量加1
                    remain++;
                    buffer[in] = productId;
                    System.out.println("***生产了产品:" + productId + "   剩余产品数量:" + remain);
                    //下一个生产产品的位置向前加1
                    in = (in + 1) % len;
                    productId++;
                }
            }
    }

    //消费商品
    public void consume()
    {
        if (remain > 0)
            synchronized (remain)
            {
                if (remain > 0)
                {
                    //剩余数量减1
                    remain--;
                    System.out.println("===消费了产品:" + buffer[out] + "   剩余产品数量:" + remain);
                    out = (out + 1) % len;
                }
            }
    }

    public static void main(String[] args)
    {
        final ConsumerAndProducer cap = new ConsumerAndProducer();
        final int time = 2000;
        final Random random = new Random();
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                while (System.currentTimeMillis() - start < time)
                {
                    cap.produce();
                    try
                    {
                        Thread.sleep(random.nextInt(10));
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                while (System.currentTimeMillis() - start < time)
                {
                    cap.consume();
                    try
                    {
                        Thread.sleep(random.nextInt(10));
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
