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
    public ListNode reverse(ListNode head){
        ListNode prev=null, curr = head, next = head.next;
        while(next!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resPrev = new ListNode();
        ListNode ptr = resPrev;

        while(head!=null){
            ListNode h = head, prev=null;
            int k1=0;
            while(head!=null && k1<k){
                prev=head;
                head=head.next;
                k1++;
            }
            if(k1==k){
                prev.next=null;
                ListNode reversed = reverse(h);
                ptr.next = reversed;
                ptr = h;
            } else {
                ptr.next = h;
            }
        }

        return resPrev.next;
    }
}
