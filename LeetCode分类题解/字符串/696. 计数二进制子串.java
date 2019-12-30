class Solution {
    public int countBinarySubstrings(String s) {
        /**
         * 1.首先，计算字符串中成组的0或1的数量，例如："0110001111"，结果为[1, 2, 3, 4]
         * 2.然后取相邻组中的较小值进行求和
         * 例如："0001111" → min(3, 4) = 3 → ("01", "0011", "000111")
         */
        // cur：保存当前组中元素0或1的数量，pre保存上一组中1或0的数量
        // 例如：011000，如果当前正在遍历"000"部分，则cur用于保存0的数量，pre代表"11"中1的数量
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                // 重新计数当前遍历到的数字的个数
                cur = 1;
            }
        }
        // 需要加上Math.min(cur, pre)
        // 因为如果遍历到字符串末尾时均为重复元素，可能没有执行该操作
        return res + Math.min(cur, pre);
    }
}