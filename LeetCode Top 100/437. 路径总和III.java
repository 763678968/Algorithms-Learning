class Solution {
    public int pathSum(TreeNode root, int sum) {
        /**
         * @key 前缀和
         * @value 有多少条路径可以得到该前缀和
         */
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return pathSumCore(root, 0, sum, preSum);
    }

    private int pathSumCore(TreeNode root, int curSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;

        curSum += root.val;
        int res = preSum.getOrDefault(curSum - target, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);

        res += pathSumCore(root.left, curSum, target, preSum) + pathSumCore(root.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return res;
    }
}
