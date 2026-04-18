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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0); 
        dfs(root, 1, 0); 
        return max;
        
    }
    private void dfs(TreeNode node, int direction, int length) {
        if (node == null) return;
        max = Math.max(max, length);
        if (direction == 0) { 
            dfs(node.left, 1, length + 1);  
            dfs(node.right, 0, 1);           
        } else { 
            dfs(node.right, 0, length + 1);  
            dfs(node.left, 1, 1);            
        }
    }
}