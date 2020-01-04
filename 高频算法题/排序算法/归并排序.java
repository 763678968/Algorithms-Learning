public class Solution {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 1)
            return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid); // 对左边子数组排序
        mergeSort(arr, mid + 1, right); // 对右边子数组排序
        merge(arr, left, mid, right); // 合并左右子数组
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 定义临时数组
        int i = left; // 定义左边数组的下标
        int j = mid + 1; // 定义右边数组的下标
        int index = 0; // 定义拷贝数组的下标
        while (i <= mid && j <= right) {
            // 左右两边相等，就先拷贝左边的（可以保证稳定性）
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        // 把左边剩余数组元素移入新数组中
        while (i <= mid)
            temp[index++] = arr[i++];
        // 把右边剩余元素移入新数组中
        while (j <= right)
            temp[index++] = arr[j++];
        // 拷贝回原数组
        for (int k = 0; k < index; k++) {
            arr[k + left] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1, -55, 2, 1, 2, 2, 53, 3, 542, 748, 14, 214};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}