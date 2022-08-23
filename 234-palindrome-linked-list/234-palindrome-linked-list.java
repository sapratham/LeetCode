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
    public boolean isPalindrome(ListNode head) {
       if(head == null || head.next == null) return true;
       ListNode mid = findMid(head);
       ListNode second = reverse(mid.next);
        
       while(head != null && second != null){
           if(head.val != second.val) return false;
           head = head.next;
           second = second.next;
       }
        return true;
    }
    public ListNode findMid(ListNode head){
       ListNode slow = head , fast = head , prev = null; 
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) return prev; // even
        return slow;
    }
    public ListNode reverse(ListNode root){
        ListNode prev = null , curr = root;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}