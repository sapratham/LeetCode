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
        public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
       
        ListNode dummy = new ListNode(-1);
        
        ListNode head = dummy , tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.val >= head2.val){
                tail.next = head2;
                head2 = head2.next;
            }else{
                tail.next = head1;
                head1 = head1.next;
            }
            tail = tail.next;
        }
        
        if(head1 != null){
            tail.next = head1;
            
        }
        else 
        tail.next = head2;
        
        return dummy.next; 
    }
    public ListNode helper(ListNode[] list,int left ,int right){
        if(left == right) return list[left];
        int mid =(left + right )/2;
        ListNode l1 = helper(list,left,mid);
        ListNode l2 = helper(list,mid +1,right);
        return mergeTwoLists(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists,0,lists.length-1);
    }
}