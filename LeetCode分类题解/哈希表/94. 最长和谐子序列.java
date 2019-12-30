class Solution {
    public int findLHS(int[] nums) {
        /**
         * 用哈希表记录各个数字出现的次数
         * 从哈希表的key中找到相差为1的两个数字，将它们的出现次数求和
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1))
                max = Math.max(max, map.get(num) + map.get(num + 1));
        }
        return max;
    }
}