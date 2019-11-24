public class Solution {
    public String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        if (n > chars.length)
            return "";
        
        int firstStart = 0;
        int firstEnd = n-1;
        int secondStart = n;
        int secondEnd = chars.length - 1;

        // 翻转字符串的前面n个字符
        reverse(chars, firstStart, firstEnd);
        
        // 翻转字符串的后面部分
        reverse(chars, secondStart, secondEnd);
        
        // 翻转整个字符串
        reverse(chars, 0, chars.length-1);

        return new String(chars);
    }
    public void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
