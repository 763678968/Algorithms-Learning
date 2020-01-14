class Solution {
    public static void bubbleSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2,4,5,1,4,5,6,8,3};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}