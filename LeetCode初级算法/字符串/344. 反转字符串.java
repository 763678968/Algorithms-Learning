class Solution {
    public void reverseString(char[] s) {
        char temp = '0';
        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            temp = s[len-1-i];
            s[len-1-i] = s[i];
            s[i] = temp;
        }
    }
}
