class LRUCache {
    Map<Integer, Node> map;
    Node dll = null;
    Node dllTail = null;
    int capacity;

    static class Node{
        int val;
        int key;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        dll = new Node(-1, -1);
        dllTail = new Node(-1, -1);
        dll.next = dllTail;
        dllTail.prev = dll;
    }

    void remove(Node node){
        Node pre = node.prev;
        Node nex = node.next;
        if(pre!=null) pre.next = nex;
        if(nex!=null) nex.prev = pre;
    }

    void addFront(Node node){
        node.next = dll.next;
        dll.next.prev = node;
        dll.next = node;
        node.prev = dll;
    }

    void removeLast(){
        Node pre2 = dllTail.prev;
        remove(pre2);
        map.remove(pre2.key);
    }

    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        //remove this node from the dll;
        Node node = map.get(key);
        remove(node);
        //add this node to front;
        addFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // check capacity;
        //if key is already there in the map, remove it from the dll and put it in node for bringing it to front.
        Node node = map.get(key);
        if(node!=null){
            remove(node);
            node.val = value;
            addFront(node);
        } else {
            if(map.size()==capacity){
                removeLast();
            }
            node = new Node(key, value);
            map.put(key, node);
            addFront(node);
        }
        //if not in map init: Node node = new Node(value); and put it in map;
        //add this node in the front;

    }
}


















