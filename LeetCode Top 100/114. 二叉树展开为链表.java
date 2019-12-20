class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    
    private TreeNode flatten(TreeNode cur, TreeNode pre) {
        if (cur == null) return pre;
        pre = flatten(cur.right, pre);
        pre = flatten(cur.left, pre);
        cur.right = pre;
        cur.left = null;
        pre = cur;
        return pre;
    }
}
