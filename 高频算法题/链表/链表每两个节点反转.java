// 迭代做法
// 迭代，使用三个指针进行交换操作：l1,l2,next
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = start;
        // 当l1和l2均不为null时才进行交换，否则只剩一个单独的节点时，保持原状
        while (cur.next != null && cur.next.next != null) {
            ListNode l1 = cur.next, l2 = cur.next.next;
            // next节点用于临时保存l2的下一个节点
            ListNode next = l2.next;
            // 依次将三个指针指向的节点进行交换
            l1.next = next;
            l2.next = l1;
            cur.next = l2;
            // 将cur指针指向下一轮操作的节点的上一个节点
            cur = l1;
        }
        return start.next;
    }
}

// 递归做法
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
}