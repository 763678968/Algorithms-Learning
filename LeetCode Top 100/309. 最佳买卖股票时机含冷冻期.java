class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] stateA = new int[prices.length];
        int[] stateB = new int[prices.length];
        int[] stateC = new int[prices.length];
        stateA[0] = -prices[0];
        stateB[0] = Integer.MIN_VALUE;
        stateC[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            stateA[i] = Math.max(stateA[i - 1], stateC[i - 1] - prices[i]);
            stateB[i] = stateA[i - 1] + prices[i];
            stateC[i] = Math.max(stateB[i - 1], stateC[i - 1]);
        }
        return Math.max(stateB[prices.length - 1], stateC[prices.length - 1]);
    }
}
