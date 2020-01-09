class Solution {
    public ListNode sortList(ListNode head) {
        /* 采用归并排序的思想 */
        if (head == null || head.next == null) {
            return head;
        }

        // 1.将链表分为两半
        ListNode slow = head, fast = head;
        // pre用于保存第一段链表的尾
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            // 令pre保存slow的上一个位置
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将第一段链表的末尾指向空（也就是将第一段与第二段链表拆分）
        pre.next = null;

        // 2.对每一半进行排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 3.将两半进行合并
        return merge(l1, l2);
    }

    // 套用归并两个链表的代码
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode cur = start;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return start.next;
    }
}