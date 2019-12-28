class Solution {
    // 定义一个全局变量sum用于存储从大到小的节点和
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        // 反方向的中序遍历，一直向右遍历到最右侧的节点
        convertBST(root.right);
        // 保存遍历过程中的节点总和
        root.val += sum;
        sum = root.val;
        // 遍历到最右侧（最大）节点之后，再去遍历该节点的左子树
        convertBST(root.left);
        return root;
    }
}
