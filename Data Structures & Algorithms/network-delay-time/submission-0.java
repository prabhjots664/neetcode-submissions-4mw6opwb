class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time : times){
            adj.putIfAbsent(time[0], new ArrayList<>());
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));//0->to, 1->time
        pq.add(new int[]{k,0});
        
        int t =0;
        Set<Integer> visitedSet = new HashSet<>(); 
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int n0 = node[0], t0 = node[1];
            if(visitedSet.contains(n0)){
                continue;
            }
            visitedSet.add(n0);
            t = t0;
            
            for (int i = 0; adj.get(n0)!=null && i < adj.get(n0).size(); i++) {
                int[] child = adj.get(n0).get(i);
                if(!visitedSet.contains(child[0])){
                    pq.offer(new int[]{child[0], child[1]+t0});
                }
            }
            
            
        }
        
        return visitedSet.size()==n? t:-1;
    }
}
