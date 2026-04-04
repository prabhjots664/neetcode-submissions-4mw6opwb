class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> gr = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            gr.get(from).add(to);
        }

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> set = new HashSet<>();
            if(dfsCycle(i, gr, set)){
                return false;
            }
        }
        return true;
    }

    private boolean dfsCycle(int i, List<List<Integer>> gr, Set<Integer> set) {

        if(set.contains(i)){
            return true;
        }
        set.add(i);

        for (int j = 0; j < gr.get(i).size(); j++) {
            if(dfsCycle(gr.get(i).get(j), gr, set)){
                return true;
            }
        }
        
        set.remove(i);

        return false;
    }
}
