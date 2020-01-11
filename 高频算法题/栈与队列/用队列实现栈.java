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