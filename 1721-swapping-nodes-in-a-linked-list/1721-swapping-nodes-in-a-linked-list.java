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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left  = head;
        ListNode right = head;
        if(head == null || head.next == null) return head;
        int count = k;
        while(count-- > 1){
            left = left.next;
        }
        ListNode temp = left;
        while(temp.next != null){
            right = right.next;
            temp = temp.next;
        }
        int temp1 = left.val;
        left.val = right.val;
        right.val = temp1;
        
        return head;
    }
}