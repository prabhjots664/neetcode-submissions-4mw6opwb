class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> gr = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            gr.add(new ArrayList<>());
            set.add(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            indegree[to]++;
            gr.get(from).add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            set.remove(curr);
            List<Integer> currChilds = gr.get(curr);
            for (int i = 0; i < currChilds.size(); i++) {
                int child = currChilds.get(i);
                indegree[child]--;
                if(indegree[child]==0){
                    q.offer(child);
                }
            }
        }

        if(!set.isEmpty()){
            return new int[0];
        }
        
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
