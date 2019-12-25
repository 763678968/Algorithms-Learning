// 迭代写法
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

// 递归写法
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseListCore(head, null);
    }
    
    private ListNode reverseListCore(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListCore(next, head);
    }
}
