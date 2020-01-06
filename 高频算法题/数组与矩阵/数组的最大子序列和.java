class Solution {
    public int maxSubArray(int[] nums) {
        /**
         * 本问题是一个求极值的最优化问题，这种问题一般可以通过动态规划来解决
         * 解决动态规划问题，关键是找到子问题的描述方式
         * 例如本问题可以将求整个数组的最大子序列，依次转换为求(0, length-2)、(0, length-3)...的子序列
         * 即maxSubArray(A, i)，i代表当前索引为i元素的子问题，对应于上述的length-2、length-3
         * 当子问题中的子序列为负值或为零，舍弃，否则保留，可以表达为如下形式：
         * maxSubArray(A, i) = maxSubArray(A, i-1) > 0 ? maxSubArray(A, i-1) : 0 + A[i]
         * 然后对最大值进行更新
         */
        int length = nums.length;
        int[] dp = new int[length];
        // 定义dp为截止目前的子序和
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            // 上一个子问题的子序和如果大于0，进行累加，反之如果小于等于0，则舍弃之前的计算结果
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            // 更新最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}