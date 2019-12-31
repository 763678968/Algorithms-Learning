class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        // 使用set存储遍历过的字符
        HashSet<Character> set = new HashSet<>();
        // 使用count记录遍历过的字符的对数
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果当前遍历的字符已经存在于set中，就将该字符从set中移除，并将字符对数+1
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else { // 如果set中不存在当前遍历的字符，就将该字符加入set
                set.add(s.charAt(i));
            }
        }
        // 如果set中有元素剩余，则表明剩余的元素落单
        // 可从中挑选出任意一个，作为aba回文串中间的那个元素，因此这里需要+1
        if (!set.isEmpty()) return 2 * count + 1;
        // 如果set中没有剩余的元素，表明原字符串中的字符都是成对出现的
        // 满足abba这种形式，不需要+1
        return 2 * count;
    }
}