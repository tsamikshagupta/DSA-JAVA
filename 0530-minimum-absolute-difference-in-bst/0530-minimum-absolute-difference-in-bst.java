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
    int min = Integer.MAX_VALUE;
    TreeSet<Integer> set = new TreeSet<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
        
    }
    private void dfs(TreeNode node){
        if(node == null) return;
        Integer floor = set.floor(node.val);
        Integer ceil = set.ceiling(node.val);
        if(floor != null){
            min = Math.min(min , node.val - floor);
        }
        if(ceil != null){
            min = Math.min(min , ceil - node.val);
        }
        set.add(node.val);
        dfs(node.left);
        dfs(node.right);

    }
}