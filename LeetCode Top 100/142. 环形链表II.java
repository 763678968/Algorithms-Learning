// 找到环形链表的入口节点
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode walker = head;
        ListNode runner = head;
        ListNode start = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                while (walker != start) {
                    start = start.next;
                    walker = walker.next;
                }
                return start;
            }
        }
        return null;
    }
}
