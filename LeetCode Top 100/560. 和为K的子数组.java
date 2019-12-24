class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
         * sum(i, j) = sum(0, j) - sum(0, i)
         * @sum(i, j) k 
         * @sum(0, j) sum
         * @sum(0, i) preSum
         * @result 子数组数量
         */
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        // 当sum = k时，result += preSum.get(0)，相当于result += 1
        // 针对 nums = [2,0,0,0], k = 2 这种情况
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k))
                result += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
