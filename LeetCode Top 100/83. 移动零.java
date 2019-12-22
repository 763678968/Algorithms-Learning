// 双指针，交换元素，效率比较低
class Solution {
    public void moveZeroes(int[] nums) {
        int fast;
        int slow = 0;
        for (fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != 0 && nums[slow] == 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
            }
            if (nums[slow] != 0)
                slow++;
        }
    }
}

// 快指针从前向后遍历数组，遇到0，就将快指针处不为0的元素覆盖到0处
// 不需要交换，遍历2次数组即可
class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int num : nums) {
            if (num != 0) nums[p++] = num;
        }
        
        while (p < nums.length) {
            nums[p++] = 0;
        }
    }
}
