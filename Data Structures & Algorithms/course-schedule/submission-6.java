class Solution {
    public boolean canFinish(int n, int[][] preq) {
        List<List<Integer>> gr = new ArrayList<>();
        for(int i =0;i<n;i++){
            gr.add(new ArrayList<>());
        }

        for(int i =0;i<preq.length;i++){
            int from = preq[i][1];
            int to = preq[i][0];
            gr.get(from).add(to);
        }

        Set<Integer> vis = new HashSet<>();
        Set<Integer> path = new HashSet<>();

        for(int i =0;i<n;i++){
            if(!vis.contains(i)){
                if(dfs(i, gr, vis, path) == false){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int i, List<List<Integer>> gr, Set<Integer> vis, Set<Integer> path){
        if(path.contains(i)){
            return false;
        }
        vis.add(i);
        
        path.add(i);
        for(int j =0;j<gr.get(i).size();j++){
            if(dfs(gr.get(i).get(j), gr, vis, path) == false){
                return false;
            }
        }
        path.remove(i);

        return true;
    }








}
