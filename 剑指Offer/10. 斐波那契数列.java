public class Solution {
    public int Fibonacci(int n) {
        if(n<0)
            throw new RuntimeException("下标错误，应从0开始！");
        
        if (n == 0 || n == 1)
            return n;
        
        int preNum = 0;
        int sufNum = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = preNum + sufNum;
            
            preNum = sufNum;
            sufNum = result;
        }
        return result;
    }
}
