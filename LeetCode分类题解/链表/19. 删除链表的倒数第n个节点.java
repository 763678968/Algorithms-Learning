class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义链表头指针
        ListNode start = new ListNode(0);
        // 定义快指针和慢指针
        ListNode slow = start, fast = start;
        start.next = head;

        // 快指针先走n+1步,此时快慢指针之间的间隔为n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        // 同时移动快慢指针，保持两者之间的间隔为n
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 慢指针跳过下一个要删除的节点，指向下下个节点
        slow.next = slow.next.next;
        return start.next;
    }
}
