// 1.通过数组构建平衡二叉树
class Solution {
    public static TreeNode arrayToTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return arrayToTreeCore(nums, 0);
    }

    // 使用广度优先搜索来序列化二叉树
    public static TreeNode arrayToTreeCore(int[] nums, int start) {
        TreeNode root = new TreeNode(nums[start]);
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        if (left > nums.length - 1) {
            root.left = null;
        } else {
            root.left = arrayToTreeCore(nums, left);
        }

        if (right > nums.length - 1) {
            root.right = null;
        } else {
            root.right = arrayToTreeCore(nums, right);
        }
        return root;
    }

    // 测试，使用前序遍历打印二叉树
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = arrayToTree(array);
        preOrder(root);
    }
}


// 2.通过有序数组构建二叉搜索树
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 因为输入数组已经排序，所以分别取数组左半边、右半边作为左子树、右子树进行递归
        if (nums.length == 0) return null;
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int low, int high) {
        if (low > high) return null; // 递归终止
        int mid = low + (high - low) / 2;
        // 取数组的中间元素，作为树的根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 取数组的左半边构造左子树
        root.left = sortedArrayToBSTCore(nums, low, mid - 1);
        // 取数组的右半边构造右子树
        root.right = sortedArrayToBSTCore(nums, mid + 1, high);
        return root;
    }
}