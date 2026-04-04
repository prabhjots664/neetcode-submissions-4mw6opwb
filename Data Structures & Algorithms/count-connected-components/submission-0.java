class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int u=edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n+1];

        int res = 0;
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                ccDfs(graph, vis, i);
                res += 1;   
            }
        }

        return res;
    }

    private void ccDfs(List<List<Integer>> graph, boolean[] vis, int i) {
        if(vis[i]) return;
        
        vis[i] = true;
        for (int j = 0; j < graph.get(i).size(); j++) {
            int k = graph.get(i).get(j);
            ccDfs(graph, vis, k);
        }
    }
}
