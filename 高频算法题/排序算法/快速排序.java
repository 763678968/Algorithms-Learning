public class Solution {
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right){
            return;
        } else {
            int partition = partitionIt(array, left, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    // 双向扫描法
    private static int partitionIt(int[] array, int left, int right) {
        int i = left;
        int j = right + 1;

        // 随机选取主元
        int random = (int) (left + Math.random() * (right - left + 1));
        swap(array, left, random);
        int pivot = array[left];

        while (true) {
            while (i < right && array[++i] < pivot) { }
            while (j > 0 && array[--j] > pivot) { }
            if (i >= j) {
                break;
            } else {
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }

    // 单向扫描法
    private static int partitionIt(int[] array, int left, int right) {
        int random = (int) (left + Math.random() * (right - left + 1));
        swap(array, left, random);
        int pivot = array[left];
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < pivot) {
                swap(array, index, i);
                index++;
            }
        }
        swap(array, left, index - 1);
        return index - 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // =================测试代码===================
    public static void main(String[] args) {
//        int[] array = {7, 3, 5, 2, 9, 8, 6, 1, 4, 7};
        int[] array = {9, 9, 8, 7 ,6, 5, 4, 3, 2, 1};
        sort(array);
        for (int i : array) {
            System.out.println(i + " ");
        }
    }
}