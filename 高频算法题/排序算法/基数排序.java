public class Solution {
    public static void radixSort(int[] arr) {
        int max = arr[0];
        // 查找数组中的最大数字
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 获取最大数字的位数，确定排序轮数
        int maxLength = (max + "").length();

        // 创建10个桶，分别存放某位为0~9的数字
        // 为了能容纳下所有的数字，每个桶的容量需要与源数组长度相同
        int[][] bucket = new int[10][arr.length];
        // 创建一个数组，保存每个桶中的数字个数
        int[] bucketElementCount = new int[10];

        // 一共需要进行maxLength轮排序
        for (int i = 0, n = 1; i < maxLength; i++, n*=10) {
            // 将数组中的元素放入桶中
            for (int j = 0; j < arr.length; j++) {
                // 根据排序的轮数，分别取出数字的个位、十位、百位...
                int digitElement = arr[j] / n % 10;
                bucket[digitElement][bucketElementCount[digitElement]] = arr[j];
                bucketElementCount[digitElement]++;
            }

            int index = 0;
            // 遍历每一个桶，从桶中取出本轮排好序的元素放入源数组中
            for (int k = 0; k < bucketElementCount.length; k++) {
                // 将非空的桶中的元素放入源数组中
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                // 将该桶元素数量清空，方便下一轮排序
                bucketElementCount[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮排序的结果为：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }
}