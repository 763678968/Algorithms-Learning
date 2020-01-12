class Solution {
    public String addBinaryString(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            result.append(carry % 2);
            carry /= 2;
        }
        return result.reverse().toString();
    }
}