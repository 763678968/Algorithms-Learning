// 使用一个队列实现栈
class MyStack {
    /**
     * 使用一个队列来实现栈
     * 每次插入一个元素，就将队列中在该元素之前的所有元素取出，再依次从队尾插入
     */
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() { }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}


// 使用两个队列实现栈
// 这种方法无法实现top()
class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() { }

    // 入栈操作
    public void push(int val) {
        queue1.offer(val);
    }

    // 出栈操作
    public int pop() {
        // 检验栈是否非空
        // 将一个队列中的n-1个数字移动到另一个队列中
        if (!empty()) {
            // queue1非空
            if (!queue1.isEmpty()) {
                moveToAnother();
                return queue1.poll();
                // queue2非空
            } else {
                moveToAnother();
                return queue2.poll();
            }
        } else {
            System.out.println("栈已经为空！");
            return -1;
        }
    }

    // 检验栈是否为空
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    private void moveToAnother() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
        }
    }
}