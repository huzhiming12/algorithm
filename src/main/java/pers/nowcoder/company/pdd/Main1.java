package pers.nowcoder.company.pdd;

import java.util.*;

/**
 * Created by huzhiming on 2017/8/1.
 * Description:
 */
public class Main1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            Queue<Integer> max = new PriorityQueue<>(3);
            Queue<Integer> max1 = new PriorityQueue<>(3);
            Queue<Integer> min = new PriorityQueue<>(3, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    return o2 - o1;
                }
            });
            boolean hasZero = false;
            for (int i = 0; i < n; i++)
            {
                int num = in.nextInt();
                if (num < 0)
                {
                    if (min.size() < 3)
                        min.add(num);
                    else
                    {
                        if (min.peek() > num)
                        {
                            min.remove();
                            min.add(num);
                        }
                    }

                    if (max1.size() < 3)
                        max1.add(num);
                    else
                    {
                        if (max1.peek() < num)
                        {
                            max1.remove();
                            max1.add(num);
                        }
                    }
                } else if (num == 0)
                    hasZero = true;
                else
                {
                    if (max.size() < 3)
                        max.add(num);
                    else
                    {
                        if (max.peek() < num)
                        {
                            max.remove();
                            max.add(num);
                        }
                    }
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            if (max.size() == 0 && !hasZero)
            {
                list.clear();
                while (!max1.isEmpty())
                    list.add(max1.poll());
            } else
            {
                while (!min.isEmpty())
                    list.add(min.poll());
                while (!max.isEmpty())
                    list.add(max.poll());
                if (hasZero)
                    list.add(0);
            }

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < list.size() - 2; i++)
                for (int j = i + 1; j < list.size() - 1; j++)
                    for (int k = j + 1; k < list.size(); k++)
                    {
                        int temp = list.get(i) * list.get(j) * list.get(k);
                        if (res < temp)
                            res = temp;
                    }

            System.out.println(res);

        }
    }
}
