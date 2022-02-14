/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow= slow.next ;
            fast = fast.next.next;
            if(fast == slow)  break;
        
        }
        if(fast == null || fast.next == null) return null;
        
        ListNode curr = head, curr2 = slow;
        while(curr != curr2){
            curr = curr.next;
            curr2 = curr2.next;
        }
        return curr2;
        
    }
}