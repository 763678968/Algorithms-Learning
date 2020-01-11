class Solution {
    /**
     * 1.利用递归方法reverseStack取出栈顶元素，直至栈为空
     * 2.每次递归向上一个步骤时，利用insertStackBottom方法，将
     * 上一步中出栈的元素插入栈底
     * 例如：栈底 -> 栈顶：0,1,2,3
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // 1.先递归地将栈中元素pop出来 temp = 3,2,1,0
        int temp = stack.pop();
        reverseStack(stack);
        // 2.调用将元素插入栈底的方法，调用顺序temp = 0,1,2,3
        insertStackBottom(stack, temp);
    }

    // 该方法用于将元素插入栈底
    public static void insertStackBottom(Stack<Integer> stack, int num) {
        // 3-1.如果栈为空，就将元素直接压入栈中
        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }
        // 3-2.如果栈非空，就将栈顶元素递归地取出，直至栈为空
        // 4.然后调用3-1将num压入栈底，并return
        int temp = stack.pop();
        insertStackBottom(stack, num);
        // 5.return之后，将3-2中递归取出的元素再压入栈中（逆序）
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        System.out.println("逆置前");
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }

        reverseStack(stack);
        System.out.println("\n逆置后");
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
    }
}