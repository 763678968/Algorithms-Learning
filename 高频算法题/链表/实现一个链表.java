// 定义链表节点
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void display() {
        System.out.println(val + "");
    }
}

// 定义链表
class LinkList {
    ListNode head = null; // 定义头节点
    int pos = 0; // 节点的位置（用于插入、删除某处的节点）

    public LinkList() {

    }

    // 插入一个头节点
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    // 删除并返回头节点
    public ListNode removeFirst() {
        ListNode tempNode = head;
        head = tempNode.next;
        return tempNode;
    }

    // 在任意位置index处插入节点
    public void add(int index, int val) {
        ListNode node = new ListNode(val);
        ListNode current = head;
        ListNode previous = head;
        while (pos != index) {
            previous = current;
            current = current.next;
            pos++;
        }
        if (index == 0) {
            node.next = current;
            head = node;
        } else {
            node.next = current;
            previous.next = node;
        }
        pos = 0;
    }

    // 删除并返回任意位置的节点
    public ListNode remove(int index) {
        ListNode current = head;
        ListNode previous = head;
        while (pos != index && current.next != null) {
            previous = current;
            current = current.next;
            pos++;
        }
        if (current == head) {
            head = head.next;
        } else {
            pos = 0;
            previous.next = current.next;
        }
        return current;
    }

    // 根据节点的值删除节点（如果有多个值相同的节点，则仅删除第一个与给定值相等的节点）
    public ListNode removeVal(int val) {
        ListNode current = head;
        ListNode previous = head;
        while (current.val != val) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    // 显示出所有的节点信息
    public void displayAll() {
        ListNode current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    // 根据位置查找节点
    public ListNode getPos(int index) {
        ListNode current = head;
        while (pos != index) {
            current = current.next;
            pos++;
        }
        pos = 0;
        return current;
    }

    // 根据值查找节点
    public ListNode getVal(int val) {
        ListNode current = head;
        while (current.val != val) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }
}

/* 测试 */
class Solution {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("原始链表：");
        list.displayAll();

        System.out.println("查找值为20的节点：" + list.getVal(20).val);
        System.out.println();

        System.out.println("查找索引为2的节点：" + list.getPos(2).val);
        System.out.println();

        list.add(3, 40);
        System.out.println("在索引3处插入40：");
        list.displayAll();

        System.out.println("删除第一个节点：" + list.removeFirst().val);
        list.displayAll();

        System.out.println("删除索引为2的节点：" + list.remove(2).val);
        list.displayAll();

        System.out.println("删除值为10的节点：" + list.removeVal(10).val);
        list.displayAll();
    }
}