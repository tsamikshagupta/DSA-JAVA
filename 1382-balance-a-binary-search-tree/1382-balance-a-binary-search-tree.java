/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> inorder = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return buildBalanced(0, inorder.size() - 1);
    }
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }
    private TreeNode buildBalanced(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(inorder.get(mid));

        node.left = buildBalanced(left, mid - 1);
        node.right = buildBalanced(mid + 1, right);
        return node;
    }
}
