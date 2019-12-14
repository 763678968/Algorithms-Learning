class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        int index = n-1;
        while (index > 0) {
            // 从右向左找到第一个递减的数
            if (nums[index-1] < nums[index])
                break;
            index--;
        }
        // 如果遍历完整个数组，也没有找到这个递减的数，就将整个数组反转
        if (index == 0) {
            reverseSort(nums, 0, n-1);
            return;
        } else {
            // 从右向左，在第一个递减的数字右侧的序列中，找到第一个比该数字大的数
            int val = nums[index-1];
            int j = n-1;
            while (j >= index) {
                if (nums[j] > val)
                    break;
                j--;
            }
            // 然后将这两个数字交换
            swap(nums, j, index-1);
            // 交换之后，再将右侧序列反转
            reverseSort(nums, index, n-1);
            return;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = 0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseSort(int[] nums, int start, int end) {
        if (start > end)
            return;
        for (int i = start; i <= (start+end)/2; i++)
            swap(nums, i, start+end-i);
    }
}
