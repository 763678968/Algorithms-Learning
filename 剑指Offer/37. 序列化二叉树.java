public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("$,");
        } else {
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
        return sb.toString();
    }

    int index = 0;
    TreeNode Deserialize(String str) {
        TreeNode node = null;
        if (str == null || str.length() == 0)
            return node;
        int start = index;
        while (str.charAt(index) != ',')
            index++;
        if (!str.substring(start, index).equals("$")) {
            node = new TreeNode(Integer.parseInt(str.substring(start, index)));
            index++;
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        } else {
            index++;
        }
        return node;
    }
}
