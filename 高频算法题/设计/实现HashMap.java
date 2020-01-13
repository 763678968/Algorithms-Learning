class MyHashMap {
    /* 采用 数组 + 链表 实现HashMap */
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 定位到指定的桶，在桶中的链表查找值为key的节点的前缀节点
    private Node find(Node bucket, int key) {
        Node node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    private int capacity;
    private final Node[] nodes;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.nodes = new Node[capacity];
    }

    // 哈希函数，计算元素的哈希值，用于定位到指定的桶
    private int index(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    public void put(int key, int value) {
        int i = index(key);
        // 如果此处的桶为空，就创建一个头节点prev
        if (nodes[i] == null) {
            nodes[i] = new Node(-1, -1);
        }
        Node prev = find(nodes[i], key);
        // 如果桶中没有元素，就创建一个新节点，用于保存key-value
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            // 否则，更新这个节点的value
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int i = index(key);
        // 如果哈希表中不存在该key，返回-1
        if (nodes[i] == null) {
            return -1;
        }
        Node node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.value;
    }

    public void remove(int key) {
        int i = index(key);
        if (nodes[i] == null) {
            return;
        }
        Node prev = find(nodes[i], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
}