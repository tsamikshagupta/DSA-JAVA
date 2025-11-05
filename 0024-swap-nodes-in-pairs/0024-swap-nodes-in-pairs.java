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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

    ListNode newHead = head.next;   
    ListNode prev = null;
    ListNode cur  = head;
    while (cur != null && cur.next != null) {
        ListNode first  = cur;          
        ListNode second = cur.next;     
        ListNode nextPair = second.next; 
        second.next = first;
        first.next  = nextPair;
        if (prev != null) {
            prev.next = second;
        }
        prev = first;   
        cur  = nextPair;
    }
    return newHead;
    }
}