class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            // 创建一个长度为0的数组，并返回
            return new int[0];
        }
        
        int[] r = new int[nums.length - k + 1];
        Deque<Integer> d = new LinkedList<>();
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当队列中第一个元素的下标超出窗口范围时，删掉该元素下标
            while (!d.isEmpty() && d.peek() < i-k+1)
                d.poll();
            // 从后往前遍历队列，当队列中相应下标的元素小于即将入队的元素nums[i]时
            // 则这个元素不可能成为窗口中的最大值，因此从队列后面移除这个元素
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i])
                d.pollLast();
            // 将元素下标存入Deque中
            d.offer(i);

            // 当i = k - 1，即形成第一个完整的窗口时
            // 队列中剩余的第一个元素就是当前窗口的最大值
            // 将队列的第一个元素存入结果数组中
            if (i >= k - 1)
                r[ri++] = nums[d.peek()];
        }
        return r;
    }
}
