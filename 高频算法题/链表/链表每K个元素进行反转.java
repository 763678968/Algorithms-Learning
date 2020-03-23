// 非递归方法
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = start;
        ListNode cur = head;
        // 计算链表长度
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        head = start.next;
        // 每K个元素反转一次链表
        for (int i = 0; i < count / k; i++) {
            for (int j = 1; j < k; j++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = cur;
            cur = prev.next;
        }
        return start.next;
    }
}


// 递归方法，内存超限
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         * 做法：一段一段地遍历链表，每段进行链表反转，最后剩余不足一段的链表，不进行反转
         * 需要注意的是反转之后两段链表的衔接：每次翻转的头结点（1、k + 1...）、翻
         * 转后两段之间连接的结点（比如1~k 和 k + 1 ~ 2k 之间连接的两个结点就是 1
         * 和 2k， 即 1 的 next 指针指向的是 2k）
         */

        // 分段遍历链表，每段的长度为k
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            // 使用current指针遍历链表
            current = current.next;
            // 当count = k - 1，也就是current指向本段链表的末尾时，结束循环
            // 如给定链表1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 4
            // 则第一段链表为1 -> 2 -> 3 -> 4，current指向4时，退出该循环
            if (count == k - 1) {
                break;
            }
        }

        // 如果本段链表长度不足k，无需反转，直接原样输出
        // 例如上述链表1 -> 2 -> 3 -> 4 -> 5 -> 6，在遍历到第二段5 -> 6时，
        // 链表长度不足4，current = null退出while循环，则此时原样输出5 -> 6
        if (current == null) {
            return head;
        }

        /* 以下为普通的反转链表操作 */
        // newHead为链表反转之后的新头节点
        ListNode newHead = null;
        // tempHead用于保存链表反转之前的头节点，同时，该节点也是本段
        // 链表反转之后的尾节点，用于与下一段链表的头节点相连
        ListNode tempHead = head;
        // 定义num用来保存需要执行反转的次数
        int num = k;
        while (num > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            num--;
        }

        // 将current指向下一次反转的链表的头节点
        current = current.next;
        // 将反转之后的链表的尾节点指向下一段链表的头节点
        tempHead.next = reverseKGroup(current, k);
        // 返回先前获取到的新头节点
        return newHead;
    }
}