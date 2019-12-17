class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果当前位置比之前能跳到的最远位置(max)还要大，则不可能跳到i处
            if (i > max) return false;
            // 更新目前能跳到的最远位置
            max = Math.max(max, nums[i]+i);
        }
        return true;
    }
}
