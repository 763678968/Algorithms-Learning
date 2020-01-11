class Solution {
    public static void swapNum(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        int a = 1, b = 5;
        swapNum(a, b); // 5 1
    }
}