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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1,0, postorder.length - 1, indexMap);
        
    }
    private TreeNode build(int[] inorder, int[] postorder,int inStart, int inEnd,int postStart,
     int postEnd ,Map<Integer, Integer> indexMap) {
        if (inStart > inEnd || postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = indexMap.get(rootVal);
        int leftSize = inorderIndex - inStart;
        root.left = build(inorder, postorder,inStart, inorderIndex - 1,postStart, postStart + leftSize - 1,
        indexMap);
        root.right = build(inorder, postorder,inorderIndex + 1, inEnd,postStart + leftSize, postEnd - 1,
        indexMap);
 return root;
    }
}