// 找出数组中最小的K个数
// 方法一：最大堆
class Solution {
    public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        // 将结果result封装到ArrayList集合中
        ArrayList<Integer> result = new ArrayList<>();
        int len = input.length;
        if (input == null || k > len || k == 0) {
            return result;
        }

        // 用优先队列来实现最大堆：最大堆的堆顶元素是堆中的最大值，k为堆的大小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < len; i++) {
            // 如果最大堆中的元素个数小于k，则直接将当前遍历到的数组元素插入堆中
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                // 当堆中元素个数已经为k时，将新遍历到的数组元素与堆顶元素进行比较
                // 如果该元素小于堆顶元素，则将堆顶元素删除，将该元素插入堆中
                Integer temp = maxHeap.poll();
                temp = null; // 释放资源
                maxHeap.offer(input[i]);
            }
            // 当遍历到的数组元素大于堆顶元素时，该元素一定不是最小的k个数之一
            // 什么也不做，直接进入下一次循环
        }

        // 将最大堆中的k个元素加入到result结果集合中
        result.addAll(maxHeap);
        return result;
    }
}


// 方法二：使用partition()方法，基于快速排序的思想。
// 时间复杂度O(n)
class Solution {
    public static ArrayList<Integer> getLeastKNumbers(int[] input, int K) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || K < 1) {
            return result;
        }

        int left = 0;
        int right = input.length - 1;
        // index表示将数组划分为左右两部分的分界点
        // index左侧数字均小于该数字，index右侧数字均大于该数字
        int index = partition(input, left, right);
        // 例如：index = 2，K = 4，表示下标为0、1、2的三个元素是数组中最小的元素
        // 而题目要求找到数组中最小的4个元素，所以需要在index右侧的大于index处的数字
        // 中继续排序，直至index = K - 1
        while (index != K - 1) {
            if (index > K - 1) { // index太靠右，需要在其左侧继续查找
                right = index - 1;
                index = partition(input, left, right);
            } else { // index太靠左，需要在其右侧继续查找
                left = index + 1;
                index = partition(input, left, right);
            }
        }
        for (int i = 0; i < K; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right + 1;
        int pivot = arr[left];
        while (true) {
            while (i < right && arr[++i] < pivot) { }
            while (j > 0 && arr[--j] > pivot) { }
            if (i >= j) {
                break;
            } else {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}