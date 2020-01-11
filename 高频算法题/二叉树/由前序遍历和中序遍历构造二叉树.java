class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 创建一个map用于保存中序遍历序列的元素位置，便于划分左右子树
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            // 保存元素位置
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        // inRoot：中序遍历根节点的位置，numsLeft：中序遍历根节点左侧（即左子树）的元素数量
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}