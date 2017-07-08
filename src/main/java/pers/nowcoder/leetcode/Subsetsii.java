package pers.nowcoder.leetcode;

import java.util.*;

/**
 * Created by huzhiming on 2017/7/2.
 * Description: 结果必须是升序的,
 * Given a collection of integers that might contain duplicates, S,
 * return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S =[1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Subsetsii
{
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num)
    {
        Arrays.sort(num);
        for (int i = 1; i <= num.length; i++)
        {
            getNum(i, 0, num.length - 1, "", num);
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>()
        {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2)
            {
                int i = 0;
                while (i < o1.size() && i < o2.size())
                {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                    i++;
                }
                if (o1.size() == i)
                    return -1;
                return 1;
            }
        });
        res.add(0, new ArrayList<Integer>());
        return res;
    }

    public void getNum(int k, int low, int high, String numString, int[] num)
    {
        if (k == 0)
        {
            if (!set.contains(numString))
            {
                String[] strs = numString.substring(1).split(",");
                ArrayList<Integer> list = new ArrayList<>();
                for (String str : strs)
                {
                    int n = Integer.parseInt(str);
                    list.add(n);
                }
                res.add(list);
                set.add(numString);
            }
        } else
        {
            for (int i = low; i <= high - k + 1; i++)
            {
                getNum(k - 1, i + 1, high, numString + "," + num[i], num);
            }
        }
    }

    public static void main(String[] args)
    {
        Subsetsii demo = new Subsetsii();
        System.out.println(demo.subsetsWithDup(new int[]{1, 2, 2, 3}));
    }
}
