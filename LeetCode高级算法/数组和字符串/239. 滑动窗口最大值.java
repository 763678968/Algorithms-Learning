/* 方法一 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i-k+1) {
                q.poll();
            }
            //remove smaller nubmers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q contains index.. r contains content
            q.offer(i);
            if (i >= k-1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }
}
// 双端队列Deque、deque.peek()、deque.poll()、deque.peekLast()、deque.offer()

/* 方法二 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int[] max_left = new int[nums.length];
        final int[] max_right = new int[nums.length];
        
        max_left[0] = nums[0];
        max_right[nums.length - 1] = nums[nums.length - 1];
        
        for (int i = 1; i < nums.length; i++) {
            max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);
            
            final int j = nums.length -i - 1;
            max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
        }
        
        final int[] sliding_max = new int[nums.length - k + 1];
        for (int i = 0, j = 0; i + k < nums.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
        }
        return sliding_max;
    }
}
