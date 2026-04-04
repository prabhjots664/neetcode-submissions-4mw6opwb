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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode left = head, right = head, left_1 = head;

        for (int i = 0; i < n-1; i++) {
            if(right!=null){
                right = right.next;
            }
        }

        while(right!=null && right.next!=null){
            right = right.next;
            left_1 = left;
            left = left.next;
        }

        if(left_1.next == left){
            left_1.next = left.next;
        } else {
            head = head.next;
        }

        return head;
    }
}
