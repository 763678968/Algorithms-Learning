class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        /**
         * 1.与108.题中通过将数组转换为二叉搜索树的思想相同
         * 2.不同之处在于，本题需要对链表进行取中（通过快慢指针）
         * 3.同时需要定义一个具有head和tail的方法，每次取链表的左半边或右半边时，
         * 需要通过方法的参数定义每段链表的头、尾
         */
        if (head == null) return null;
        return sortedListToBSTCore(head, null);
    }

    private TreeNode sortedListToBSTCore(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        // 链表头尾相等时，结束递归
        if (head == tail) return null;

        // 查找链表的中点，注意这里的链表尾部不是null，而是方法中定义的tail
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 定义树的节点为链表的中点
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBSTCore(head, slow);
        node.right = sortedListToBSTCore(slow.next, tail);
        return node;
    }
}
