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
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;

        Set<ListNode> set = new HashSet<>();
        while (curr != null && curr.next != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }

        return false;
    }
}
