class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            count = num == 0 ? 0 : count + 1;
            max = Math.max(count, max);
        }
        return max;
    }
}