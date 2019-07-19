/**
The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        
        return xor ^ i;
    }
}
// 异或运算^

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (0+len) * (len+1) / 2;
        for (int i=0; i<len; i++)
            sum -= nums[i];
        return sum;
    }
}
// 求和

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid = (left + right)/2;
        while (left < right) {
            mid = (left + right)/2;
            if (nums[mid] > mid) 
                right = mid;
            else 
                left = mid+1;
        }
        return left;
    }
}
// 二分查找，在数组有序的情况下，该方法较好
