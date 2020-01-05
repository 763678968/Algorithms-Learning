// 1.暴力法，直接将数组排序，输出相应位置的元素即可
class Solution {
    public static int getKthLargestElement(int[] input, int K) {
        if (input == null || input.length < 1 || K < 1 || K > input.length) {
            return Integer.MAX_VALUE;
        }

        Arrays.sort(input);
        return input[input.length - K];
    }
}

// 2.基于快速排序的partition方法
// 与找出前K大的元素几乎完全相同，只有最后的return处不同
class Solution {
    public static int getKthLargestElement(int[] input, int K) {
        if (input == null || input.length < 1 || K < 1 || K > input.length) {
            return Integer.MAX_VALUE;
        }

        int left = 0;
        int right = input.length - 1;
        int index = partition(input, left, right);
        while (index != K - 1) {
            if (index > K - 1) {
                right = index - 1;
                index = partition(input, left, right);
            } else {
                left = index + 1;
                index = partition(input, left, right);
            }
        }
        // 此处不需要遍历排序后的矩阵，直接返回第K - 1个元素即可
        return input[K - 1];
    }

    public static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right + 1;
        int pivot = arr[left];

        while (true) {
            while (i < right && arr[++i] > pivot) { }
            while (j > 0 && arr[--j] < pivot) { }
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

// 3.最小(大)堆
class Solution {
    public static int getKthLargestElement(int[] input, int K) {
        if (input == null || input.length < 1 || K < 1 || K > input.length) {
            return Integer.MAX_VALUE;
        }

        // 创建最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(K, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 在堆中存放数组中前K大的元素
        for (int i = 0; i < input.length; i++) {
            if (minHeap.size() != K) {
                minHeap.offer(input[i]);
            } else if (input[i] > minHeap.peek()) {
                Integer temp = minHeap.poll();
                temp = null;
                minHeap.offer(input[i]);
            }
        }
        // 堆的容量为K，堆顶元素为堆中的最小元素，则堆顶元素即为数组中第K大的元素
        return minHeap.peek();
    }
}

