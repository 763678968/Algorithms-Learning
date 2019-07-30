/*
the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i=0, j=0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
// map.containsKey()方法、String.charAt()方法、map.get()方法、map.put()方法

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s != null && s.length() > 0) {
            int[] index = new int[128];
            int max = 0;
            for (int i=0, j=0; j < s.length(); j++) {
                i = Math.max(i, index[s.charAt(j)]);
                max = Math.max(max, j-i+1);
                index[s.charAt(j)] = j + 1;
            }
            return max;
        }
        return 0;
    }
}
// 更快
