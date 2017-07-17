package pers.leetcode.contest41;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by huzhiming on 2017/7/16.
 * Description:
 */
public class _636_ExclusiveTimeofFunctions
{
    public static int[] exclusiveTime(int n, List<String> logs)
    {
        Stack<Function> stack = new Stack<>();
        List<Function> list = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++)
        {
            String[] str = logs.get(i).split(":");
            if (str[1].equals("start"))
            {
                int begin = Integer.parseInt(str[2]);
                int num = Integer.parseInt(str[0]);
                Function function = new Function(num, begin);
                stack.add(function);
            } else
            {
                Function temp = stack.pop();
                int end = Integer.parseInt(str[2]);
                int num = Integer.parseInt(str[0]);
                temp.total = end - temp.begin + 1;
                list.add(temp);

                if (!stack.isEmpty())
                {
                    Function parent = stack.peek();
                    parent.children.add(temp);
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < list.size(); i++)
        {
            int value = list.get(i).total;
            for (Function function : list.get(i).children)
                value -= function.total;
            res[list.get(i).num] += value;
        }
        return res;
    }

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("1:start:6");
        list.add("1:end:6");
        list.add("0:end:7");
        System.out.println(Arrays.toString(exclusiveTime(2, list)));
    }
}

class Function
{
    public Function(int num, int begin)
    {
        this.num = num;
        this.begin = begin;
    }

    int num;
    int begin;
    int total;
    List<Function> children = new ArrayList<>();
}

