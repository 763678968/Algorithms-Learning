// 不构造HashMap的做法
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = pathSumWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }

    private int pathSumWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (sum - root.val == 0) res++;
        res += pathSumWithRoot(root.left, sum - root.val) + pathSumWithRoot(root.right, sum - root.val);
        return res;
    }
}
