//import com.sun.jdi.Value;
//
//import java.security.Key;
//
//public class RedBlackBST {
//
//    private Node root;
//    private static final boolean RED = true;
//    private static final boolean BLACK = false;
//
//    private class Node {
//        Key key;          // 键
//        Value val;        // 相关联的值
//        Node left, right; // 左右子树
//        int N;            // 这棵子树中的结点总数
//        boolean color;    // 由其父结点指向它的链接的颜色
//
//        Node(Key key, Value val, int N, boolean color) {
//            this.key = key;
//            this.val = val;
//            this.N = N;
//            this.color = color;
//        }
//    } // 含有color变量的Node对象（请见3.3.2.4节）
//
//    private boolean isRed(Node x) {
//        if (x == null) return false;
//        return x.color == RED;
//    }    // 请见3.3.2.4节
//
//    private Node rotateLeft(Node h) {
//        Node x = h.right;
//        h.right = x.left;
//        x.left = h;
//        x.color = h.color;
//        h.color = RED;
//        x.N = h.N;
//        h.N = 1 + size(h.left) + size(h.right);
//        return x;
//    } // 请见图3.3.16
//
//    private Node rotateRight(Node h) {
//        Node x = h.left;
//        h.left = x.right;
//        x.right = h;
//        x.color = h.color;
//        h.color = RED;
//        x.N = h.N;
//        h.N = 1 + size(h.left) + size(h.right);
//        return x;
//    } // 请见图3.3.17
//
//    private void flipColors(Node h) {
//        h.color = RED;
//        h.left.color = BLACK;
//        h.right.color = BLACK;
//    }  // 请见图3.3.21
//
//    public void put(Key key, Value val) {
//        // 查找key，找到则更新其值，否则为它新建一个结点
//        root = put(root, key, val);
//        root.color = BLACK;
//    }
//
//    private Node put(Node h, Key key, Value val) {
//        if(h == null) // 标准的插入操作，和父结点用红链接相连
//            return new Node(key, val, 1, RED);
//
//        int cmp = key.compareTo(h.key);
//        if (cmp < 0) h.left = put(h.left, key, val);
//        else if (cmp > 0) h.right = put(h.right, key, val);
//        else h.val = val;
//
//        if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
//        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
//        if (isRed(h.left) && isRed(h.right))     flipColors(h);
//
//        h.N = size(h.left) + size(h.right) + 1;
//    }
//
//    public int size() {
//        return size(root);
//    }
//
//    private int size(BST.Node x) {
//        if (x == null)
//            return 0;
//        else
//            return x.N;
//    }
//
//    public Value get(Key key) {
//        return get(root, key);
//    }
//
//    private Value get(BST.Node x, Key key) {
//        // 在以x为根结点的子树中查找并返回key所对应的值；
//        // 如果找不到则返回null
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0)        return get(x.left, key);
//        else if (cmp > 0)   return get(x.right, key);
//        else                return x.val;
//    }
//
//    public Key min() {
//        return min(root).key;
//    }
//
//    private BST.Node min(BST.Node x) {
//        if (x.left == null) return x;
//        return min(x.left);
//    }
//
//    public Key floor(Key key) {
//        BST.Node x= floor(root, key);
//        if (x == null) return null;
//        return x.key;
//    }
//
//    private BST.Node floor(BST.Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp == 0) return x;
//        if (cmp < 0) return floor(x.left, key);
//        BST.Node t= floor(x.right, key);
//        if (t != null) return t;
//        else           return x;
//    }
//
//    public Key max() {
//        return max(root).key;
//    }
//
//    private BST.Node max(BST.Node x) {
//        if (x.right == null) return x;
//        return max(x.right);
//    }
//
//    public Key ceiling(Key key) {
//        BST.Node x= ceiling(root, key);
//        if (x == null) return null;
//        return x.key;
//    }
//
//    private BST.Node ceiling(BST.Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp == 0) return x;
//        if (cmp > 0) return ceiling(x.right, key);
//        BST.Node t= ceiling(x.left, key);
//        if (t != null) return t;
//        else           return x;
//    }
//
//    public Key select(int k) {
//        return select(root, k).key;
//    }
//
//    private BST.Node select(BST.Node x, int k) {
//        // 返回排名为k的结点
//        if (x == null) return null;
//        int t = size(x.left);
//        if (t > k) return select(x.left, k);
//        else if (t < k) return select(x.right, k-t-1);
//        else return x;
//    }
//
//    public int rank(Key key) {
//        return rank(key, root);
//    }
//
//    private int rank(Key key, BST.Node x) {
//        // 返回以x为根结点的子树中小于x.key的键的数量
//        if (x == null) return 0;
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0) return rank(key, x.left);
//        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
//        else return size(x.left);
//    }
//
//    public void deleteMin() {
//        root = deleteMin(root);
//    }
//
//    private BST.Node deleteMin(BST.Node x) {
//        if (x.left == null) return x.right;
//        x.left = deleteMin(x.left);
//        x.N = size(x.left) + size(x.right) + 1;
//        return x;
//    }
//}
