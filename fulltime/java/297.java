/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helper(root);
        return sb.toString();
    }

    private void helper(TreeNode node) {
        if (node == null) {
            sb.append("# ");
            return;
        }
        sb.append(node.val + " ");
        helper(node.left);
        helper(node.right);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");
        if (values.length == 0) return null;
        return buildTree(values, new int[]{0});
    }

    private TreeNode buildTree(String[] values, int[] index) {
        if (index[0] >= values.length) return null;
        if (values[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]++]));
        node.left = buildTree(values, index);
        node.right = buildTree(values, index);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
