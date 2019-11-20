// 题解1：二叉搜索树
public TreeNode getLowestCommonParentBST(TreeNode root, TreeNode node1, TreeNode node2) {
    while (true) {
        if (root == null)
            return root;
        if (root.val < node1.val && root.val < node2.val)
            root = root.right;
        if (root.val > node1.val && root.val > node2.val)
            root = root.left;
        else
            return root;
    }
}


// 题解2：普通二叉树，无父指针
public TreeNode getLowestCommonParentBST(TreeNode root, TreeNode node1, TreeNode node2) {
    if (root == null || root == node1 || root == node2)
        return root;
    TreeNode left = getLowestCommonParentBST(root.left, node1, node2);
    TreeNode right = getLowestCommonParentBST(root.right, node1, node2);
    return left==null? right : right==null? left : root;
    //        上面这句代码等价为：
    //        if (left == null) {
    //            return right;
    //        } else if (right == null) {
    //            return left;
    //        } else {
    //            return root;
    //        }
}
