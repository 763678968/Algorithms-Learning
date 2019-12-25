/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        /**
         * 1.首先计算链表的长度
         * 2.然后根据链表长度计算分隔之后每段的长度，需要取余、相除，将前余数个数的分段的长度分别+1
         * 3.将节点依次放入同一个分段中
         * 4.将当前分段的最后一个节点指向null，即打断链表，并记录原始链表中下一个节点的位置
         * 5.开始存储下一个分段
         */
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int mod = len % k; // 计算余数，这个余数代表前mod个分段的长度需要+1
        int size = len / k; // 计算每个分段的长度
        ListNode[] res = new ListNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            res[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0); // 计算当前分段的长度，余数不为0时则长度+1，否则不+1
            for (int j = 0; j < curSize - 1; j++) { // 找到当前分段的末尾
                cur = cur.next;
            }
            // 打断链表
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
