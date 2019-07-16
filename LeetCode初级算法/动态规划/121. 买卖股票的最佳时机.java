class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
// Kadane算法
// maxCur = current maximum value
// maxSoFar = maximum value found so far

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length==0 || prices==null) return 0;
        
        int minprice = prices[0];
        int maxprice = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i]-minprice > maxprice) {
                maxprice = prices[i] - minprice;
            }
        }
        return maxprice;
    }
}
// 运行时间缩短一半
