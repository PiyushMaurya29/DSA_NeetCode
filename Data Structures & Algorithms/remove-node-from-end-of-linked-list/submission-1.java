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
    public int getLength(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i=1 ; i<=n ; i++){
            fast = fast.next;
        }
        if(fast == null) return null;
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;


        // int length = getLength(head);
        // int fromStart = length-n+1;
        // if(fromStart == 1) return head.next;
        // ListNode temp = head;
        // for(int i=1 ; i<=fromStart-2 ; i++){
        //     temp = temp.next;
        // }
        // temp.next = temp.next.next;
        // return head;
    }
}
