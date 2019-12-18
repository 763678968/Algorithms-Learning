class Solution {
    public int climbStairs(int n) {
        /**
         * 首先确定边界条件，如果爬1级台阶，只有1种方法；如果爬2级台阶，则有2种方法
         * 因此，如果需要爬到任意一个台阶，则最后一次有可能爬了1个台阶或2个台阶
         * 总方法数等于爬1个台阶之前的总方法数+爬2个台阶之前的总方法数
         */
        int[] dp = new int[n + 1];

        if (n < 3) {
            dp[n] = n;
            return dp[n];
        }
        else {
            dp[0] = 0; dp[1] = 1; dp[2] = 2;
            for (int i = 3; i < n+1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}

class Solution {
    public int climbStairs(int n) {
        /**
         * 首先确定边界条件，如果爬1级台阶，只有1种方法；如果爬2级台阶，则有2种方法
         * 因此，如果需要爬到任意一个台阶，则最后一次有可能爬了1个台阶或2个台阶
         * 总方法数等于爬1个台阶之前的总方法数+爬2个台阶之前的总方法数
         */

        // 边界条件
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 一步以前的总方法数
        int one_step_before = 2;
        // 两步以前的总方法数
        int two_steps_before = 1;
        // 总方法数
        int all_ways = 0;

        // 这种做法与上一种思路基本相同，但是不需要开数组存储之前的结果
        // 以下思路可以基于滑动窗口考虑
        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            // 下一次循环的两步之前，就是本次循环的一步之前
            two_steps_before = one_step_before;
            // 下一次循环的一步之前，就是本次循环的总方法数
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
