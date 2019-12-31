// 遍历到每个元素都需要查找哈希表，较慢
class Solution {
    public boolean containsDuplicate(int[] nums) {
        /**
         * 用一个哈希表存储遍历过的元素
         * 如果遇到先前已经在哈希表中存在的元素，立即返回true
         */
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}

// 利用set中不能存在重复元素的特性，最终比较set的大小是否小于数组长度即可
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}