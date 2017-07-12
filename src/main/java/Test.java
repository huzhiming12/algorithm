import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by huzhiming on 2017/7/11.
 * Description:
 */
class AA
{
    static class B
    {
        public void test()
        {
            System.out.println(b);
            method();
        }
    }

    class A
    {
        void test()
        {
            System.out.println(a + "" + c);
            method();
        }
    }

    public static int b = 3;
    public int a = 1;
    private int c;

    private static void method()
    {
        System.out.println("外部类的静态方法");
    }
}

class MyCallable implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println(i + " " + Thread.currentThread().getName());
            Thread.sleep(100);
        }
        return 10;
    }
}

public class Test
{
    public static void main(String[] args)
    {
        MyCallable callable1 = new MyCallable();
        FutureTask task1 = new FutureTask(callable1);
        new Thread(task1).start();

        MyCallable callable2 = new MyCallable();
        FutureTask task2 = new FutureTask(callable2);
        new Thread(task2).start();
        try
        {
            Thread.sleep(2000);
            System.out.println(task1.get());
            System.out.println(task2.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }


    }
}