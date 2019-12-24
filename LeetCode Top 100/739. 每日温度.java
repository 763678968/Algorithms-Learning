class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 暴力法：遍历每一个元素，再遍历其之后的每一个元素，从中找到第一个大于这个元素的元素
        // 返回其下标与当前下标之差
        int[] res = new int[T.length];
        
        for (int i = 0; i < T.length; i++) {
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}

// 用栈进行查找，假设给定输入为[5,4,3,2,6,7]
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            // 2.如果遍历到一个比之前温度高的元素，如6
            // 5.然后再次比较栈顶元素的温度与上上个元素的温度，重复下去
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                // 3.从栈顶弹出该元素的索引
                int index = stack.pop();
                // 4.与上一个元素的索引相减
                res[index] = i - index;
            }
            // 1.将比当前温度低的索引存入栈中，如[5,4,3,2]
            stack.push(i);
        }
        return res;
    }
}

// 使用数组构造栈
class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 用数组构造一个栈
        int[] stack = new int[T.length];
        int[] res = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int index = stack[top--];
                res[index] = i - index;
            }
            stack[++top] = i;
        }
        return res;
    }
}
