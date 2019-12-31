class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            // 定义快、慢指针，指针指向数组中元素的值，而不是索引
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow != fast) {
                // 慢指针一次走一步，快指针一次走两步
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            // 当两指针相遇时，根据环形链表的入口判断方法
            // 令快指针重新从数组开头出发，慢指针从两指针相遇处出发
            // 二者以相同的速度前进，则快慢指针再次相遇的地方即为重复的数字
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}