class Solution {
    public int[] findOrder(int n, int[][] preq) {
        List<List<Integer>> gr = new ArrayList<>();
        for(int i =0;i<n; i++){
            gr.add(new ArrayList<>());
        } 
        int[] indegree = new int[n];
        for(int i =0;i<preq.length;i++){
            int to = preq[i][0];
            int from = preq[i][1];
            gr.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int visCount  = 0;
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int polled = q.poll();
            visCount++;
            res.add(polled);
            for(Integer child : gr.get(polled)){
                if(--indegree[child] == 0){
                    q.offer(child);
                }
            }
        }

        int[] resArr = new int[res.size()];
        for(int i =0;i<res.size();i++){
            resArr[i] = res.get(i);
        }

        return visCount==n ? resArr:new int[0];
    }
}
