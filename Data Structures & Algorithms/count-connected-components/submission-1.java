class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;
        for(int i =0;i<edges.length;i++){
            if(dsu.union(edges[i][0], edges[i][1])){
                res--;
            }
        }
        return res;
    }

}


class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    } 

    public int find(int i){
        if(parent[i]==i){
            return i;
        }
        return find(parent[i]);
    }

    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py){
            return false;
        }

        if(rank[px]>rank[py]){
            parent[py] = px;
            rank[px] += rank[py];
        } else {
            parent[px] = py;
            rank[py] += rank[px];
        }
        return true;
    }
}




