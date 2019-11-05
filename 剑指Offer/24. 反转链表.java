// 三指针
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pNode = head;
        ListNode preNode = null;
        ListNode nextNode = pNode.next;
        while (nextNode != null) {
            pNode.next = preNode;
            preNode = pNode;
            pNode = nextNode;
            nextNode = pNode.next;
        }
        // 只有一个节点的情况
        pNode.next = preNode;
        return pNode;
    }
}

// 递归
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rvsHead = ReverseList(head.next);
        // 找到了最后的头节点之后，开始转换每个节点的指向
        head.next.next = head;
        head.next = null;
        return rvsHead;
    }
}
