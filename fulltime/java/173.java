/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    Stack<TreeNode> st;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = null;
        while (cur != null) {
            st.push(cur);
            cur = cur.left;
        }
        res = st.pop();
        cur = res.right;
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
