// 与70.爬楼梯类似
// 递归
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }
}

// 迭代 + memo数组
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i + 1] = Math.max(memo[i - 1] + nums[i], memo[i]);
        }
        return memo[nums.length];
    }
}

// 迭代 + 两个变量
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        // nums[i] - 1
        int prev1 = 0;
        // nums[i] - 2
        int prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}
