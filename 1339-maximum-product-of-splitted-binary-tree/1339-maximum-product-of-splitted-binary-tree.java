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
    private static final int MOD = 1_000_000_007;
    private long totalSum = 0;
    private long maxProduct = 0;
    public int maxProduct(TreeNode root) {
        totalSum = computeTotalSum(root);
        computeSubtreeSum(root);
        return (int) (maxProduct % MOD);
        
    }
     private long computeTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + computeTotalSum(node.left) + computeTotalSum(node.right);
    }
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        long left = computeSubtreeSum(node.left);
        long right = computeSubtreeSum(node.right);
        long subtreeSum = node.val + left + right;
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }

}