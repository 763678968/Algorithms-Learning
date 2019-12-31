class Solution {
    public int findShortestSubArray(int[] nums) {
        // 创建两个哈希表，分别用于存储元素第一次出现的位置，和出现的次数
        HashMap<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        // 创建res用于储存结果，degree用于储存数组的度
        int res = 0, degree = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果哈希表中没有该元素，就存入该元素和它的索引（表示第一次出现）
            first.putIfAbsent(nums[i], i);
            // 统计元素出现的次数
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            // 如果当前元素的频率大于数组的度，则将度更新为该元素的频率
            // 同时计算与该元素第一次出现时所组成子数组的长度
            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            } else if (count.get(nums[i]) == degree) {
                // 如果该元素的频率等于数组的度，则直接与先前的最短子数组长度作比较，取较小者
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}