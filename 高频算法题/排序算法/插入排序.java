class Solution {
    public static void insertionSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && array[preIndex] > current) {
                // 将所有比插入元素大的元素整体后移一位
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = {8,8,3,7,6,5,4,3,2,1};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}