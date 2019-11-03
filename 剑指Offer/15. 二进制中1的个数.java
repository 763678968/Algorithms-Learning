public class Solution {
    
    // 可能陷入死循环的方法
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            /*
            * 用1和n进行位与运算，
            * 结果要是为1则n的2进制形式
            * 最右边那位肯定是1，否则为0
            */
            if ((n & 1) == 1)
                count++;
            // 将n的二进制形式向右移一位
            n = n >> 1;
        }
        return count;
    }
    
    // 常规解法
    
}
