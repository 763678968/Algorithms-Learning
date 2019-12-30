class Solution {
    public int[] findErrorNums(int[] nums) {
        // 先将数组中各个数字交换到正确的位置
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }

        // 交换完成之后，查找错误的数字
        // 返回的数组，第一位为重复的数字，第二位为缺失的数字
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1)
                return new int[] {nums[i], i + 1};
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}