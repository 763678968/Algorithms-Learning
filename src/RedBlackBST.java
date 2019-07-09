import com.sun.jdi.Value;

import java.security.Key;

public class RedBlackBST {

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;          // 键
        Value val;        // 相关联的值
        Node left, right; // 左右子树
        int N;            // 这棵子树中的结点总数
        boolean color;    // 由其父结点指向它的链接的颜色

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    } // 含有color变量的Node对象（请见3.3.2.4节）

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }    // 请见3.3.2.4节

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    } // 请见图3.3.16

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    } // 请见图3.3.17

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }  // 请见图3.3.21

    private int size(BST.Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }  // 请见算法3.3

    public void put(Key key, Value val) {
        // 查找key，找到则更新其值，否则为它新建一个结点
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if(h == null) // 标准的插入操作，和父结点用红链接相连
            return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
    }
}
