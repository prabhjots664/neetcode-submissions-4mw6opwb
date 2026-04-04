/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Node cloneNode = cloneNodeByDFS(node, map);

        return cloneNode;
    }

    private Node cloneNodeByDFS(Node node, Map<Node, Node> map) {
        if(node==null) return null;
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        List<Node> childNodes = new ArrayList<>();
        for (int i = 0; i < node.neighbors.size(); i++) {
            if(!map.containsKey(node.neighbors.get(i))){
                childNodes.add(cloneNodeByDFS(node.neighbors.get(i), map));
            } else {
                childNodes.add(map.get(node.neighbors.get(i)));
            }
        }
        cloneNode.neighbors = childNodes;

        return cloneNode;
    }
}