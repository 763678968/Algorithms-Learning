// 基础做法
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }
}

// 基于快速排序思想的做法
class Solution {
    public int findKthLargest(int[] nums, int k) {
        /**
         * 基于快速排序思想，查找partition
         * partition右侧的元素均大于partition本身
         * 因此当partition等于k = nums.length - k时，就找到了第K个最大元素
         */
        // 对输入数组打乱顺序，结果可以保持在O(n)时间复杂度
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] array, int left, int right) {
        int i = left;
        int j = right + 1;
        while (true) {
            // 双向搜索
            while (i < right && array[++i] < array[left]) { }
            while (j > left && array[--j] > array[left]) { }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // 构造一个洗牌方法，打乱输入数组的顺序，避免出现快速排序的最坏情况
    private void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 1; i < array.length; i++) {
            int r = random.nextInt(i + 1);
            swap(array, i, r);
        }
    }
}
