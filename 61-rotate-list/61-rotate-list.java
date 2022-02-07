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
    public ListNode rotateRight(ListNode head, int k) {
         if(k==0 || head == null || head.next==null)
            return head;
        ListNode tail = head ,tail2 = head;
        int count = 1; 
        while(tail.next != null){
            tail = tail.next;
            count++;
        }
        if(k == count) return head;
        int temp = k % count;
        tail.next = head;
        int move = count - temp;
        int temp2 = move;
        while(move-- > 0){
            head = head.next;
         }
        while(temp2-- > 1){
            tail2 = tail2.next;
        }
        tail2.next = null;
        return head;
        
    }
}