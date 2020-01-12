// 大数相加
class Solution {
    public String addString(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int i = str1.length() - 1, j = str2.length() - 1;
        int carry = 0;
        while (carry == 1 || i >= 0 || j >= 0) {
            // 当两字符串长度不等时，在较短的字符串前面补0
            int x = i < 0 ? 0 : str1.charAt(i--) - '0';
            int y = j < 0 ? 0 : str2.charAt(j--) - '0';
            result.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return result.reverse().toString();
    }
}