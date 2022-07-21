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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        if(left == right) return head;
       
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy , curr = dummy;
        
        for(int i = 0 ; i < left ; i++){
            prev = curr;
            curr = curr.next;
        }
        int diff = right - left;
        for(int i = 0 ; i < diff ; i++){
            ListNode after = curr.next;
            curr.next = after.next;
            after.next = prev.next;
            prev.next = after;
        }
        return dummy.next;
    }
}