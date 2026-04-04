class Solution {
     public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+2];
        int[] rank =  new int[edges.length+2];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if(!union(edge[0], edge[1], parent, rank)){
                return edge;
            }
        }
        return new int[0];
    }
    
    int find(int x, int[] parent){
        if(x!=parent[x]){
            return find(parent[x], parent);
        }
        return x;
    }
    
    boolean union(int x, int y, int[] parent, int[] rank){
        int px = find(x, parent);
        int py = find(y, parent);
        
        if(px==py){
            return false;
        }
        
        if(rank[px]>rank[py]){
            rank[px] += rank[py];
            parent[py] = px;
        } else {
            rank[py] += rank[px];
            parent[px] = py;
        }
        
        return true;
    }
}
