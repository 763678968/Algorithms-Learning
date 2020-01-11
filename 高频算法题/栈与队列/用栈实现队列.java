class MyQueue {
    /**
     * 构建两个栈，in用来实现将元素加入队列中，out用于实现将元素从队列中取出
     * 入栈时，元素顺序被反转，此时，将in中的元素全部取出，再压入out中，元素顺序就会与最初加入队列的顺序相同
     * 1.push操作只需要in就可以完成
     * 2.peek、pop操作需要先将in中的全部元素转移到out中，再通过对out进行操作来完成
     * 3.转移操作只有在out为空时才能进行
     */
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() { }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();
    }

    // 创建一个用于将in中所有元素转移到out中的方法
    // 该方法只有在out为空时才能执行
    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}