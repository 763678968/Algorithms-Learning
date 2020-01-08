public class Solution {
    public boolean hasCycle(ListNode head) {
        /**
         * 使用快慢指针，同时出发，快指针一次两步，慢指针一次一步
         * 则如果链表中有环，快慢指针总会相遇，返回true
         * 如果链表中没有环，则快指针遍历到头结束，返回false
         */
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return true;
        }
        return false;
    }
}