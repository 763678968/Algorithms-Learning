class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};

        // 查找元素的第一个位置
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        if (target == nums[low])
            res[0] = low;
        else
            res[0] = -1;

        // 查找元素的最后一个位置
        high = nums.length - 1;
        while (low < high) {
            // 如果不+1，因为除法取整，mid的值总是偏向左侧
            int mid = low + (high - low) / 2 + 1;
            if (target < nums[mid])
                high = mid - 1;
            else
                low = mid;
        }
        if (target == nums[high])
            res[1] = high;
        else
            res[1] = -1;

        return res;
    }
}
