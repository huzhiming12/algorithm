import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by huzhiming on 2017/7/11.
 * Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        System.out.println(test());
    }

    public static int test() throws RuntimeException
    {
        int x =12;
        try
        {
            x++;
            return x;
        } catch (Exception e)
        {

        } finally
        {
            System.out.println("这是finally函数块");
            x++;
            //return 12;
        }
        return 0;
    }
}
