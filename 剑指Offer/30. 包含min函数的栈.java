public class Solution {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    Integer temp = null;
    
    public void push(int node) {
        if (temp != null) {
            if (node <= temp) {
                temp = node;
                min.push(node);
            }
            data.push(node);
        } else {
            temp = node;
            data.push(node);
            min.push(node);
        }
    }
    
    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if (num != num2)
            min.push(num2);
    }
    
    public int top() {
        int num = data.peek();
        return num;
    }
    
    public int min() {
        int num = min.peek();
        return num;
    }
}
