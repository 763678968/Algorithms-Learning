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
        // 请见算法3.3（续1）
    }

    public void put(Key key, Value val) {
        // 请见算法3.3（续1）

        // max()、min()、floor()、ceiling()方法请见算法3.3（续2）
        // select()、rank()方法请见算法3.3（续3）
        // delete()、deleteMin()、deleteMax()方法请见算法3.3（续4）
        // keys()方法请见算法3.3（续5）
    }
}
