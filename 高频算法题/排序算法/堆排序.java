public class Solution {

    public static void heapSort(int[] array) {
        int temp = 0;
        // 从最后一个非叶子节点向上构建最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        for (int j = array.length - 1; j > 0; j--) {
            // 交换堆顶元素与最后一个元素
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, j);
        }
    }

    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 如果左子节点小于右子节点，则指向右子节点
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            // 如果子节点大于父节点，就将较大的值赋给当前节点
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        // 将temp值放到调整后的位置
        array[i] = temp;
    }

    public static void main(String[] args) {
        int array[] = {4, 6, 8, 9, 5, 22, 34, -2, -5, 65};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}