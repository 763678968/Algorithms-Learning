class Solution {
    public int longestConsecutive(int[] nums) {
        /**
         * 使用哈希表来存储连续序列的长度，问题的关键是找到连续序列的边界点
         * 例如：给定序列{1,2,3,4,5}，这里1,5为序列的边界，map.get(1)和map.get(5)应该都等于5
         * 当一个元素num要插入map中时，需要做两件事情：
         * 1.查找map中是否存在num - 1和num + 1，如果存在，则表明num的左侧或右侧存在连续的序列，
         * 此时left、right分别代表左侧、右侧连续序列的长度；而如果left、right为0，则代表
         * num两边不存在连续的序列，num将作为之后查找到的序列的边界点。将left + right + 1作为
         * num左右两侧连续序列的总长度，存入map的value中
         * 2.分别使用第一步中的left、right的长度，来定位到以num为中心的连续序列的两个边界点，
         * 并更新连续序列的最大长度。
         */
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
                int right = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
                // sum表示以num为中心的左右两侧序列总长
                int sum = left + right + 1;
                map.put(num, sum);
                // 更新最大长度
                res = Math.max(res, sum);

                // 根据左右两边的序列长度，找到序列的两个边界点
                // 如果num左右两边没有邻居，则这一步什么也不做
                map.put(num - left, sum);
                map.put(num + right, sum);
            } else {
                // 存在重复元素，跳过，进入下一次循环
                continue;
            }
        }
        return res;
    }
}