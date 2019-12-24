class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum < S || ((sum + S) & 1) != 0 ? 0 : findTargetSumWaysCore(nums, (sum + S) >> 1);
    }

    private int findTargetSumWaysCore(int[] nums, int S) {
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int num : nums)
            for (int i = S; i >= num; i--)
                dp[i] += dp[i - num];
        return dp[S];
    }
}
