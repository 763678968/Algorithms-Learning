class Solution {
    public ListNode findKthToTail(ListNode head, int k) {
        // 定义两个指针，初始都指向链表的头节点
        ListNode fast = head;
        ListNode slow = head;
        // 记录k值
        int a = k;
        // 记录节点的个数
        int count = 0;
        // fast指针先跑，并且记录节点数，当fast指针跑了k-1个节点后，slow指针开始跑
        // 当fast指针跑到最后时，slow所指指针就是倒数第k个节点
        while (fast != null) {
            fast = fast.next;
            count++;
            // 如果k <= 0，slow指针与fast指针从一开始就同时向后移
            // 最终slow指针会指向null，最后会返回null
            if (k < 1) {
                slow = slow.next;
            }
            k--;
        }
        // 如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < a) return null;
        return slow;
    }
}