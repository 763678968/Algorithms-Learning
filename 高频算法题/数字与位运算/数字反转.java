class Solution {
    public static int reverseInt(int num) {
        int result = 0;
        while (num != 0) {
            int tail = num % 10;
            int newResult = 10 * result + tail;
            // 此处result由上式移项得来，如果newResult溢出，则下式计算的结果一定不等于result
            // 例如newResult = 10 * Integer.MAX_VALUE + 1，此时newResult溢出，结果为-9
            // 所以下面按照移项结果逆推时，result一定不等于newResult，排除了溢出的情况
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        System.out.println(a);
    }
}
