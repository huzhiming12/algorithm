package pers.nowcoder.offer;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class _52_构建乘积数组
{
    public int[] multiply(int[] A)
    {
        int len = A.length;
        int[] head = new int[len];
        int[] back = new int[len];
        head[0] = 1;
        back[0] = 1;
        for (int i = 1; i < len; i++)
        {
            head[i] = head[i - 1] * A[i - 1];
            back[i] = back[i - 1] * A[len - i];
        }
        int[] B = new int[len];
        for (int i = 0; i < len; i++)
        {
            B[i] = head[i] * back[len - i - 1];
        }
        return B;
    }
}
