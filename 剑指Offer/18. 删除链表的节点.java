public class Solution {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int value, ListNode nextNode) {
            val = value;
            next = nextNode;
        }
    }

    public ListNode deleteNode(ListNode head, ListNode pToBeDeleted) {
        // 待删除节点是头节点或链表为空
        if (head == null || pToBeDeleted == null)
            return head;
        // 待删除节点不是尾节点
        if (pToBeDeleted.next != null) {
            ListNode nextNode = pToBeDeleted.next;
            pToBeDeleted.val = nextNode.val;
            pToBeDeleted.next = nextNode.next;
            nextNode = null;
        // 只有一个节点，（既是头节点，又是尾节点）
        } else if (head == pToBeDeleted) {
            pToBeDeleted = null;
            head = null;
        // 链表包含多个节点，删除尾节点
        } else {
            ListNode preNode = head;
            while (preNode.next != pToBeDeleted && preNode != null)  {
                preNode = preNode.next;
            }
            // preNode == null检验待删除元素是否在链表中
            if (preNode == null) {
                System.out.println();
                return head;
            }
            preNode.next = null;
            pToBeDeleted = null;
        }
        return head;
    }

    // ===============测试代码=================
    void test(ListNode head, ListNode PToBeDelete) {
        System.out.println("===================");
        System.out.println("The original list is: ");
        ListNode curr = head;
        if (curr != null) {
            while (curr.next != null) {
                System.out.print(curr.val + ",");
                curr = curr.next;
            }
            System.out.println(curr.val);
        } else {
            System.out.println();
        }

        System.out.println("The node to be deleted is: ");
        if (PToBeDelete != null)
            System.out.println(PToBeDelete.val);
        else
            System.out.println();

        curr = deleteNode(head, PToBeDelete);
        System.out.println("The result list is:");
        if (curr != null) {
            while (curr.next != null) {
                System.out.println(curr.val + ",");
                curr = curr.next;
            }
            System.out.println(curr.val);
        } else {
            System.out.println();
        }
        System.out.println("===================");
    }

    /**
     * 链表含多个节点，删除头节点
     */
    void test1() {
        ListNode p4 = new ListNode(4, null);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        test(p1, p1);
    }

    /**
     * 链表含多个结点，删除中间结点
     */
    void test2() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p3);
    }

    /**
     * 链表含多个结点，删除尾结点
     */
    void test3() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p4);
    }

    /**
     * 链表含一个结点，删除结点
     */
    void test4() {
        ListNode p4=new ListNode(4, null);
        test(p4, p4);
    }

    /**
     * 链表为空
     */
    void test5() {
        test(null, null);
    }

    public static void main(String[] args) {
        Solution demo = new Solution();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
    }
}
