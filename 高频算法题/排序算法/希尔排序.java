class Solution {
    public static void shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int len = array.length;
        int gap = len / 2;
        int current;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                current = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && current < array[preIndex]) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] array = {8,8,3,7,6,5,4,3,2,1};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
