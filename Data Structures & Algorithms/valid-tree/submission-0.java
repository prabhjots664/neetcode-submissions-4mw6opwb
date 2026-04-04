class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
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

        boolean hasCycle = dfsUndirected(graph, 0, -1, set);
        return !hasCycle && set.size()==n;
    }

    private boolean dfsUndirected(List<List<Integer>> graph, int i, int parent, Set<Integer> set) {

        if(set.contains(i)){
            return true;
        }
        set.add(i);

        for (int j = 0; j < graph.get(i).size(); j++) {
            int child = graph.get(i).get(j);
            if(child!=parent){
                if(dfsUndirected(graph, child, i, set)){
                    return true;
                }
            }
        }

        return false;
    }
}
