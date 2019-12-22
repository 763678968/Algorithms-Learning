class Solution {
    /**
     * 1.使用快慢指针遍历链表，当快指针到达链表末尾，即fast.next == null或fast == null时，退出循环
     * 2.如果链表长度为奇数，即fast指针最终停留在链表的最后一个元素处，此时需要让slow指针再向前一步
     * 3.将链表反转，原来的链表被拆分为左右两个链表
     * 4.快慢指针分别从两个链表的头相向而行，如果节点值不同则不是回文链表
     *
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 奇数元素链表的特殊处理
        if (fast != null)
            slow = slow.next;

        slow = reverse(slow); // 反转链表
        fast = head; // 令fast指针指向原链表的头节点

        // 两个指针相向而行，当为奇数时，slow指针遍历到null结束，剩余的中间元素归左侧链表，返回true
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    // 反转链表的实现
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
