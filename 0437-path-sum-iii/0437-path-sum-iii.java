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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, targetSum, map);
        
    }
    private int dfs(TreeNode node, long currentSum, int target, HashMap<Long, Integer> map) {
        if (node == null) return 0;
        currentSum += node.val;
        int count = map.getOrDefault(currentSum - target, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        count += dfs(node.left, currentSum, target, map);
        count += dfs(node.right, currentSum, target, map);
        map.put(currentSum, map.get(currentSum) - 1);
        return count;
    }
}