// 基础做法，存在大量的重复计算，时间复杂度为指数级
// 如在计算rob(root)的过程中，需要计算rob(root.left), rob(root.right), rob(root.left.left), rob(root.left.right), rob(root.right.left), rob(root.right.right)
// 而在计算rob(root.left)的过程中，同样需要计算rob(root.left.left), rob(root.left.right)
class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        /**
         * 两种情况：
         * 1.如果偷了父节点，则只能再偷父节点下面的4个孙子节点
         * 2.如果没有偷父节点，则可以偷父节点下面的2个孩子节点
         */
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}

// 创建HashMap保存遍历过的节点
class Solution {
    public int rob(TreeNode root) {
        return robCore(root, new HashMap<>());
    }

    private int robCore(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        // 创建一个HashMap来存储遍历过的节点
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robCore(root.left.left, map) + robCore(root.left.right, map);
        }
        if (root.right != null) {
            val += robCore(root.right.left, map) + robCore(root.right.right, map);
        }

        val = Math.max(val + root.val, robCore(root.left, map) + robCore(root.right, map));
        map.put(root, val);

        return val;
    }
}

// 最优解
class Solution {
    public int rob(TreeNode root) {
        int[] res = robCore(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robCore(TreeNode root) {
        if (root == null) return new int[2];

        /**
         * 定义只有两个元素的数组res、left、right
         * 第一位表示root节点没被偷的情况下，所能偷到的最大金额
         * 第二位表示root节点被偷的情况下，所能偷到的最大金额
         * left、right分别表示root节点的左右子节点的所能偷到的最大金额
         */
        int[] left = robCore(root.left);
        int[] right = robCore(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
