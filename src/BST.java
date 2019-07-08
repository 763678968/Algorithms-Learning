public class BST<Key extends Comparable<Key>, Value> {

    private Node root;                  // 二叉查找树的根节点

    private class Node {
        private Key key;                // 键
        private Value val;              // 值
        private Node left, right;       // 指向子树的链接
        private int N;                  // 以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        // 在以x为根结点的子树中查找并返回key所对应的值；
        // 如果找不到则返回null
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        return get(x.left, key);
        else if (cmp > 0)   return get(x.right, key);
        else                return x.val;
    }

    public void put(Key key, Value val) {
        // 查找key，找到则更新它的值，否则为它创建一个新的结点
        root = put(root, key, val);

        // max()、min()、floor()、ceiling()方法请见算法3.3（续2）
        // select()、rank()方法请见算法3.3（续3）
        // delete()、deleteMin()、deleteMax()方法请见算法3.3（续4）
        // keys()方法请见算法3.3（续5）
    }

    private Node put(Node x, Key key, Value val) {
        // 如果key存在于以x为根结点的子树中则更新它的值；
        // 否则将以key和val为键值对的新结点插入到该子树中
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x= floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t= floor(x.right, key);
        if (t != null) return t;
        else           return x;
    }
}
