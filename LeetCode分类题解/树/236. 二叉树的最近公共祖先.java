class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 2.如果存在等于p或q的节点，则返回该节点
        if (root == q || root == p) return root;
        
        // 1.查找root的左右子树中是否存在等于p或q的节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 3.如果查找完左右子树，都不存在等于p、q的节点，则返回null，表示没有找到
        if (left == null && right == null) return null;
        // 4.如果根节点root的左右子树分别查找到相应的节点，则返回他们的根节点root
        if (left != null && right != null) return root;
        
        // 5.如果查找完后，一个子树找到相应节点，另一个子树没找到相应节点
        // 则返回找到节点的那个子树的结果
        return left == null ? right : left;
    }
}
