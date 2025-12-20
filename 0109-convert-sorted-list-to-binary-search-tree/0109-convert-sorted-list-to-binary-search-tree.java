/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        current = head;
        return buildTree(0, size - 1);
        
    }
    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    private TreeNode buildTree(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode leftChild = buildTree(left, mid - 1);
        TreeNode root = new TreeNode(current.val);
        root.left = leftChild;
        current = current.next;
        root.right = buildTree(mid + 1, right);

        return root;
}
}