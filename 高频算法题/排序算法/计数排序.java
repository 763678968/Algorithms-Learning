public class Solution {
    public static int[] countingSort(int[] arr) {
        // 首先找到最大、最小元素
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        // 定义结果数组
        int[] result = new int[arr.length];
        // 定义计数数组
        int[] count = new int[max - min + 1];
        // 定义下标偏移量
        int bias = -min;

        // 对源数组进行计数，考虑偏移量
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + bias]++;
        }
        // 将先前的计数进行累加
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // 倒序遍历源数组，将元素放入计数数组中储存的相应位置上
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--(count[arr[i] + bias])] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 2, 6, 8, 22, 23, -5, 8};
        int[] result = countingSort(arr);
        System.out.println(Arrays.toString(result));
    }
}
