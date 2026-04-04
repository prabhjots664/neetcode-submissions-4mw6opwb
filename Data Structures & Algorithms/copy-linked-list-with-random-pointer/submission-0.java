/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node h = head;
	    Node cNode = null, pre = null;
	    Node cHead = null;
	    Map<Node, Node> map = new HashMap<>();// 
	    
	    while(head!=null){
	   
	        cNode = new Node(head.val);
	        
	        map.put(head, cNode);
	        
	        if(pre!=null){
	            pre.next = cNode;
	        } else {
	            //if pre is null
	            cHead = cNode;
	        }
	        pre = cNode;
	        head = head.next;
	    }
	    
	    //cHead is the head of normal clone.
	    Node cloneResultNode = cHead;
	    
	    head = h;
	    while(head!=null){
	        cNode = map.get(head);
	        Node cRandom = map.get(head.random);
	        cNode.random = cRandom;
	        
	        head=head.next;
	    }
	    
	    
	    
	    return cloneResultNode;
    }
}
