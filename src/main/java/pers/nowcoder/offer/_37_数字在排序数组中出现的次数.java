package pers.nowcoder.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */

public class _37_数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int low = 0;
        int high = array.length - 1;
        if (k > array[high] || k < array[0])
            return 0;

        low = getMin(array, k);
        high = getMax(array, k);
        if (low<0 || high<0)
            return 0;

        return high - low + 1;
    }

    public int getMin(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k)
                high = mid - 1;
            else if (arr[mid] < k)
                low = mid + 1;
            else {
                res = mid;
                high = mid - 1;
            }
        }
        if (arr[low] == k)
            return low;
        return res;
    }

    public int getMax(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k)
                high = mid - 1;
            else if (arr[mid] < k)
                low = mid + 1;
            else {
                res = mid;
                low = mid + 1;
            }
        }
        if (arr[low] == k)
            return low;
        return res;
    }

    public static void main(String[] args) {
        _37_数字在排序数组中出现的次数 demo = new _37_数字在排序数组中出现的次数();
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(demo.GetNumberOfK(arr, 3));
    }
}
