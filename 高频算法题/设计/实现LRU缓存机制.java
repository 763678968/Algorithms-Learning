// 哈希表 + 双向链表
public class LRUCache {
    // 创建双向链表的节点类
    class Node {
        int key;
        int value;
        Node pre;
        Node post;
    }

    // 约定：双向链表的头部是最近操作过的元素，尾部是最久没有操作的元素
    // 这里使用的一个技巧是：设置一个伪头节点(head)和伪尾节点(tail)，
    // 其余节点的插入和删除都是在这两个节点之间进行，这样可以避免在更新链表
    // 元素的过程中检查是否为null，简化了操作

    // 一直在双向链表的头节点之后插入元素
    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    // 删除双向链表中的某个节点
    private void removeNode(Node node) {
        Node pre = node.pre;
        Node post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    // 将双向链表中间的某个元素移至头部
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // 删除双向链表尾部元素
    private Node popTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }

    private HashMap<Integer, Node> cache = new HashMap<>();
    private int count;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 将操作过的节点移至双向链表头部
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++count;

            if (count > capacity) {
                // 删除末尾的元素
                Node tail = popTail();
                cache.remove(tail.key);
                --count;
            }
        } else {
            // 更新这个值
            node.value = value;
            moveToHead(node);
        }
    }
}