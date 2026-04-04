class TimeMap {
    
    static class Node{
        String value;
        int timestamp;
        Node(String value, int timestamp){
            this.timestamp=timestamp;
            this.value=value;
        }
    }
    
    Map<String, TreeSet<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new TreeSet<>((a,b)->Integer.compare(a.timestamp, b.timestamp))).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        }
        
        TreeSet <Node> set = map.get(key);
        Node node = set.floor(new Node("value", timestamp));
        if(node==null){
            return "";
        
        }
        
        return node.value;
    }
}