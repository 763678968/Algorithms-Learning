import java.util.Arrays;

public class Solution {
    public static int[] mergeSort(int[] c, int start, int last) {
        if (last > start) {
            // 也可以是(start+last)/2，这样写是为了防止数组长度很大造成两者相加超过int范围，导致溢出
            int mid = start + (last - start) / 2;
            mergeSort(c, start, mid); // 左边数组排序
            mergeSort(c, mid+1, last); // 右边数组排序
            merge(c, start, mid, last); // 合并左右数组
        }
        return c;
    }

    public static void merge(int[] c, int start, int mid, int last) {
        int[] temp = new int[last-start+1]; // 定义临时数组
        int i = start; // 定义左边数组的下标
        int j = mid + 1; // 定义右边数组的下标
        int k = 0;
        while (i <= mid && j <= last) {
            if (c[i] < c[j]) {
                temp[k++] = c[i++];
            } else {
                temp[k++] = c[j++];
            }
        }
        // 把左边剩余数组元素移入新数组中
        while(i <= mid) {
            temp[k++] = c[i++];
        }
        // 把右边剩余数组元素移入新数组中
        while (j <= last) {
            temp[k++] = c[j++];
        }

        // 把新数组中的数覆盖到c数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            c[k2+start] = temp[k2];
        }
    }

    // ===================测试代码=====================
    public static void main(String[] args) {
        int[] c = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        c = mergeSort(c, 0, c.length-1);
        System.out.println(Arrays.toString(c));
    }
}
