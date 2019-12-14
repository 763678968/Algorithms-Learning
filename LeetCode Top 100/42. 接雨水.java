class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        if (n == 0 || n == 1)
            return result;

        int left = 0, right = n - 1;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
                right--;
            }
        }
        return result;
    }
}
