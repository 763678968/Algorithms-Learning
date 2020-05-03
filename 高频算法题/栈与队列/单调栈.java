// LeetCode 496.下一个更大元素I
class Solution {
    // 输入参数只有一个数组
    public int[] nextGreaterElement(int[] nums) {
        // 存放答案的数组
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // 倒着往栈中插入元素
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                // 将中间被遮挡住的矮个子元素移除
                stack.pop();
            }
            // 取当前元素后面的第一个高个子元素
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            // 将当前元素入栈，进入下一轮判断
            stack.push(nums[i]);
        }
        return res;
    }

    // 输入参数为两个数组
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            int greater = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], greater);
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}


// LeetCode 503.下一个更大元素II（循环数组）
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        // 循环数组的处理方法：
        // 1.假设将数组复制一份，接在原数组的末尾，这样可以让每个元素与它的左右两侧元素进行比较
        for (int i = 2 * N - 1; i >= 0; i--) {
            // 2.令数组元素下标对数组长度取余，表示模拟的环形结构
            while (!stack.isEmpty() && stack.peek() <= nums[i % N]) {
                stack.pop();
            }
            res[i % N] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % N]);
        }
        return res;
    }
}


// LeetCode 739.每日温度
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        // 创建一个栈，用于存放元素索引
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            // 获取索引间距
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // 将元素索引入栈，而不是元素本身
            stack.push(i);
        }
        return res;
    }
}