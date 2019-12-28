class Solution {
    private int curCount = 1;
    private int maxCount = 1;
    // 定义当前节点的上一个节点为preNode
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        // 创建list用于存储出现次数最多的数字
        List<Integer> maxCountNums = new ArrayList<>();
        inOrder(root, maxCountNums);
        // 定义一个结果数组，其长度与list长度相同
        int[] res = new int[maxCountNums.size()];
        int index = 0;
        // 将list中的元素存入数组中
        for (int num : maxCountNums) {
            res[index++] = num;
        }
        return res;
    }

    // 对BST进行中序遍历，并将出现次数最多的数字存入list中
    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if (preNode != null) {
            // 如果上一个节点的值等于当前节点的值，将当前数字出现的次数+1
            if (preNode.val == node.val) curCount++;
            // 否则将当前数字记为第一次出现
            else curCount = 1;
        }
        // 如果当前节点的出现次数大于此前数字出现的最大次数
        if (curCount > maxCount) {
            // 就更新最大次数为当前数字的出现次数
            maxCount = curCount;
            // 并清空先前list中储存的出现次数最多的数字
            nums.clear();
            // 将当前数字添加到list中
            nums.add(node.val);
        } else if (curCount == maxCount) {
            // 如果当前数字出现的次数与最大次数相等，则将该数字加入到list队列中
            nums.add(node.val);
        }
        // 将上一个节点更新为当前的节点，准备下一次循环
        preNode = node;
        inOrder(node.right, nums);
    }
}
