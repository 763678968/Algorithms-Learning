// 栈
class Solution {
    public void printFromTailToStart(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}


// 递归
class Solution {
    public static void printTailToStartRec(ListNode head) {
        if(head != null){
            // 递归终止条件：head的后继节点为空
            if(head.next != null){
                printTailToStartRec(head.next);  // 递归
            }
            System.out.println(head.val);
        }else{
            System.out.println("输入的链表为空！");
        }
    }

    // 测试
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;

        printTailToStartRec(head);
    }
}