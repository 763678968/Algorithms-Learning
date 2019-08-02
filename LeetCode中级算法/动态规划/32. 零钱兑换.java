class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }
    
    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if (rem < 0) return -1; // not valid
        if (rem == 0) return 0; // completed
        if (count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if (res >= 0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }
}
// 递归方法，非常慢

class Solution {
    public int coinChange(int[] coins, int amount) {
       int[] dp = new int[amount + 1];
       Arrays.fill(dp, amount + 1); 
       dp[0] = 0; 
       for(int j = 0; j < coins.length; j++){
         for(int i = 0; i <= amount; i++){
           if(i - coins[j] >= 0) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); 
         } 
       } 
       return dp[amount] > amount ? -1 : dp[amount];
    }
}
// 较快
