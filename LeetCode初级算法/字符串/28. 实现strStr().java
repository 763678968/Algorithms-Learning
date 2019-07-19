class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
// 比较慢

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0, j = needle.length(); i+j <= haystack.length(); i++) {
            if (haystack.substring(i, i+j).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
// 中等速度

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        return haystack.indexOf(needle, 0);
    }
}
// java内置方法 最快
