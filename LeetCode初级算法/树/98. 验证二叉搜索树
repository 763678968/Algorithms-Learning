/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
// 与230.二叉搜索树中第K小的元素 93.二叉树的中序遍历 三道题对照着看

class Solution {
    private long lastVal = Long.MIN_VALUE;
    private boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag;
    }
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (node.val <= lastVal) {
            flag = false;
            return;
        }
        lastVal = node.val;
        dfs(node.right);
    }
}
// 更快
