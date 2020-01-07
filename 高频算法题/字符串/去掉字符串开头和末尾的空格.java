class Solution {
    public static String trim(String str) {
        int begin = 0;
        int end = str.length() - 1;
        while (begin < end && str.charAt(begin) == ' ') {
            begin++;
        }
        while (begin < end && str.charAt(end) == ' ') {
            end--;
        }
        return str.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        String str = "   abasd  sdfwe  ";
        System.out.println(trim(str));
    }
}