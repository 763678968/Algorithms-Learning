// 递归
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
}

// 迭代，使用三个指针进行交换操作：l1,l2,next
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = start;
        while (cur.next != null && cur.next.next != null) {
            ListNode l1 = cur.next, l2 = cur.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            cur.next = l2;
            cur = l1;
        }
        return start.next;
    }
}
