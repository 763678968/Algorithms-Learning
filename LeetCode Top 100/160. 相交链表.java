public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;

        while (cur1 != cur2) {
            cur1 = (cur1 == null? headB : cur1.next);
            cur2 = (cur2 == null? headA : cur2.next);
        }
        return cur1;
    }
}
