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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0 ;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
       temp = dummy;
    
        while(temp.next != null){
            if(length < k){
                break;
            }
            int count = k - 1;
            ListNode tempNext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;
            while(count-- > 0){
                ListNode next = second.next;
                second.next = first;
                first = second ;
                second = next;
            }
            temp.next = first;
            tempNext.next = second;
            temp = tempNext;
            length -= k;
        }
        return dummy.next;
    }
}