// LeetCode 239.滑动窗口的最大值
class Solution {
    class MonotonicQueue {
        Deque<Integer> data = new LinkedList<>();

        public void push(int n) {
            // 将小于待插入元素的所有元素从队尾删除
            // 最终单调队列中剩余的元素呈现递减排列
            while (!data.isEmpty() && data.peekLast() < n) {
                data.pollLast();
            }
            data.offerLast(n);
        }

        public void pop(int n) {
            // 检查队首的元素是否为要删除的元素，如果不是
            // 则该元素可能在插入元素的过程中已经被删除
            if (!data.isEmpty() && data.peekFirst() == n) {
                data.pollFirst();
            }
        }

        public int max() {
            // 直接获取单调队列的队首元素，即为最大元素
            return data.peekFirst();
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 先把窗口前k - 1个元素填满
            if (i < k - 1) {
                window.push(nums[i]);
                // 窗口向前滑动
            } else {
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }
}