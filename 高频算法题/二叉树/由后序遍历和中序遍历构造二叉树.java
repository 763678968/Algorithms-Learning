class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeCore(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    public TreeNode buildTreeCore(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeCore(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, inMap);
        root.right = buildTreeCore(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inMap);
        return root;
    }
}