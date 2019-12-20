class Solution {
    public int maxProduct(int[] nums) {
        /**
         * 由于
         * 1.之前最小的负数乘积 与 当前遍历到的负数 相乘会得到 最大的乘积
         * 2.之前最大的正数乘积 与 当前遍历到的负数 相乘会得到 最小的乘积
         * 3.之前最大的正数乘积 与 当前遍历到的正数 相乘 需要与第一种情况比较
         * 因此，需要记录先前最大的乘积、最小的乘积，分别与当前所遍历的元素相乘
         * 然后比较当前元素、先前最大乘积与当前元素乘积、先前最小乘积与当前元素乘积
         * 相应记录为maxHere、minHere
         * 同时，更新maxSoFar的值，为最后所求的结果
         */
        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int maxSoFar = nums[0];
        int maxHere;
        int minHere;

        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(Math.max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }
        return maxSoFar;
    }
}
