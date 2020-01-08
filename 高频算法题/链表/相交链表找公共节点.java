// 两个无环链表求交点
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = (curA == null ? headB : curA.next);
            curB = (curB == null ? headA : curB.next);
        }
        return curA;
    }
}


// 两个有环链表求交点（环内相交、环外相交）
class Solution {
    // 假定先前已经求得两个链表的入环节点node1、node2
    public ListNode getIntersectionNode(ListNode headA, ListNode nodeA, ListNode headB, ListNode nodeB) {
        // 环外相交的情况（包括交点与入环节点重合的情况）
        if (nodeA == nodeB) {
            // 使用set保存链表A中遍历过的节点
            HashSet<ListNode> set = new HashSet<>();
            while (headA != nodeA) {
                set.add(headA);
                headA = headA.next;
            }
            // 遍历链表B，查找set中是否存在与B中相同的节点，如果存在，即为交点
            while (headB != nodeB) {
                if (set.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            // 如果上述过程中没有找到交点，则入环节点即为两个链表的交点
            return nodeA;
        } else {
            // 两个6型链表相交 + 环内相交（环入口节点不同）
            ListNode current = nodeA.next;
            // 从其中一个入环节点开始遍历整个环
            while (current != nodeA) {
                // 如果找到了另一个入环节点，则两条链表相交，返回其中任意一个入环节点即可
                if (current == headB) {
                    return headB;
                }
                current = current.next;
            }
            // 否则说明两个链表没有交点
            return null;
        }
    }
}