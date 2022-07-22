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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        
        ListNode lefttail = left;
        ListNode righttail = right;
        
        ListNode curr = head;
            while(curr != null){
                if(curr.val < x){
                    lefttail.next = curr;
                    lefttail = curr;
                }else{
                    righttail.next = curr;
                    righttail = curr;
                }
                curr = curr.next;
            }
        lefttail.next = right.next;
        righttail.next = null;
        return left.next;
    }
}