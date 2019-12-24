class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        // 如果sum为奇数，则不存在所求的结果
        if ((sum & 1) == 1)
            return false;
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        dp[0][0] = true;

        // j = 0可以由前i个数字求和得到（一个数字也不选取），第一列置为true
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        // 0个数字不能得到一个大于0的数字j，第一行置为false
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        // 其他位置，根据递推关系式求解：dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                // 这里的nums[i - 1]是因为nums数组的下标是从0开始的
                // 而动态规划表dp的下标是从1开始的，二者之间有-1的对应关系
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }
        return dp[n][sum];
    }
}

// 使用一维数组进行简化
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        // 如果sum为奇数，则不存在所求的结果
        if ((sum & 1) == 1)
            return false;
        sum /= 2;

        // 用一维数组进行简化
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num)
                    dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}
