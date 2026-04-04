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

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode prev=null, curr=head, next=curr.next;

        while(next!=null){
            curr.next=prev;

            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next=prev;

        return curr;
    }

    public void reorderList(ListNode head) {
        ListNode curr = head, l1 = head;

        //count nodes = n
        int n = 0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }

        //traverse till n/2+1 and break the list from there
        int nby2 = 0;
        curr = head;
        ListNode prev = head;
        while(nby2 < n/2){
            nby2++;
            prev = curr;
            curr = curr.next;
        }
        prev.next=null;

        //reverse the second half
        ListNode l2 = curr;
        l2 = reverseList(l2);

        //sieve both lists together.
        ListNode l1next = l1, l2next = l2,l1prev = l1,l2prev=l2;
        while (l1!=null && l2!=null){
            l1next=l1.next;
            l2next=l2.next;
            l1.next = l2;
            l2.next = l1next;

            l1prev = l1;
            l2prev = l2;
            l1=l1next;
            l2=l2next;
        }

        if(l2!=null){
            l2prev.next = l2; 
        }

    }
}
