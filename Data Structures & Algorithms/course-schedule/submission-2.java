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

    // We will reuse the same set as the current recursion path
    Set<Integer> path = new HashSet<>();

    for (int i = 0; i < numCourses; i++) {
        if (dfsCycle(i, gr, path)) {
            return false;
        }
        // after finishing DFS from i, ensure it's not in the current path
        path.remove(i);
    }
    return true;
}

private boolean dfsCycle(int i, List<List<Integer>> gr, Set<Integer> path) {

    if (path.contains(i)) {
        return true;          // back-edge -> cycle
    }

    path.add(i);

    for (int j = 0; j < gr.get(i).size(); j++) {
        int nei = gr.get(i).get(j);
        if (dfsCycle(nei, gr, path)) {
            return true;
        }
        // when we return from child, make sure child is not kept in path
        path.remove(nei);
    }

    return false;
}

}
