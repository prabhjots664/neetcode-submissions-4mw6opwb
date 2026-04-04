
class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node dll, tail;
    
    static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val = val;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        dll = new Node(-1, -1);
        tail = new Node(-1, -1);
        dll.next=tail;
        tail.prev=dll;
    }
    
    void remove(Node node){
        Node left = node.prev, right = node.next;
        left.next=right;
        right.prev=left;
        map.remove(node.key);
    }
    
    void addToFront(Node node){
        Node right = dll.next;
        dll.next=node;
        node.prev=dll;
        
        node.next=right;
        right.prev=node;
        
        map.put(node.key, node);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToFront(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node;
        if(!map.containsKey(key)){
            node = new Node(key, value);
            if(map.size()==capacity){
                //remove last
                Node last = tail.prev;
                remove(last);
            }
        } else {
            node = map.get(key);
            node.val = value;
            remove(node);
        }
        
        addToFront(node);
        
    }
}
