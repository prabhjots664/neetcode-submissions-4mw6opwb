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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode node : lists){
            pq.offer(node);
        }
        ListNode res = new ListNode(-999999);
        ListNode ptr = res;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next!=null){
                pq.offer(node.next);
            }
            ptr.next=node;
            ptr=ptr.next;
        }
        return res.next;
    }
}
