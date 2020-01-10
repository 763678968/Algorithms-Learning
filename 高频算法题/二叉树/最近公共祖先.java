// 二叉树的最近公共祖先
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
        // 则表明两个节点在root节点的同一侧（左侧或右侧），父节点是两个节点中的一个
        return left == null ? right : left;
    }
}


// 二叉搜索树的最近公共祖先
// 递归
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

// 迭代
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
    }
}