// LeetCode 198.打家劫舍I
class Solution {
    // 基础的自顶向下递归方法，存在重叠子问题，会超时
    public int rob(int[] nums) {
        return dp(nums, 0);
    }

    private int dp(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        // 对于面前的房子，只有两种选择：1.抢，2.不抢
        // 需要在这两种选择中取较大值
        int res = Math.max(dp(nums, index + 1), // 不抢
                dp(nums, index + 2) + nums[index]); // 抢
        return res;
    }
}


class Solution {
    // 使用备忘录（剪枝）对上述递归方法进行优化
    private int[] memo;

    public int rob(int[] nums) {
        // 创建备忘录，并初始化为-1，表示该位置没有存储元素
        // 不初始化为0是因为输入的nums可能全为0
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        // 从备忘录中获取已经存在的值
        if (memo[index] != -1) {
            return memo[index];
        }
        // 对于面前的房子，只有两种选择：1.抢，2.不抢
        // 需要在这两种选择中取较大值
        int res = Math.max(dp(nums, index + 1), // 不抢
                dp(nums, index + 2) + nums[index]); // 抢
        // 存入备忘录
        memo[index] = res;
        return res;
    }
}


class Solution {
    // 第二种方法，使用DP数组，自底向上进行计算
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp数组的含义为：从当前的房屋开始抢劫，抢到最后一间房屋，所能抢到的金额
        int[] dp = new int[nums.length + 2];
        // Base Case为dp[nums.length - 1] = 0，所以从后向前遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}


class Solution {
    // 使用两个变量代替DP数组，对上述方法进行空间优化
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 因为状态转移只与最近的两个状态有关，所以使用两个变量来代替DP数组
        // pre代表当前元素的后一个元素，suf代表当前元素的后两个元素
        int pre = 0, suf = 0;
        // 使用变量res记录DP的结果
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res = Math.max(pre, suf + nums[i]);
            suf = pre;
            pre = res;
        }
        return res;
    }
}


// LeetCode 213.打家劫舍II
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 首尾两个房屋不能同时抢劫，所以一共只有三种情况
        // 1.抢劫第一间房屋，2.抢劫最后一间房屋，3.首尾两间房屋都不抢劫
        // 但是情况一和情况二包括了情况三，所以只需要对情况一和情况二进行比较即可
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }

    private int dp(int[] nums, int start, int end) {
        int pre = 0, suf = 0;
        // 使用变量res记录DP的结果
        int res = 0;
        for (int i = end; i >= start; i--) {
            res = Math.max(pre, suf + nums[i]);
            suf = pre;
            pre = res;
        }
        return res;
    }
}


// LeetCode 337.打家劫舍III
class Solution {
    // 二叉树的备忘录使用HashMap实现
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 从备忘录中获取先前计算过的结果
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 抢，之后去下下家
        int do_it = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，去下一家
        int not_do = rob(root.left) + rob(root.right);
        int res = Math.max(do_it, not_do);
        // 将结果存入到备忘录中
        memo.put(root, res);
        return res;
    }
}