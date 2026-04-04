class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        boolean[][] pvis = new boolean[n+1][m+1];
        boolean[][] avis = new boolean[n+1][m+1];
        for (int i = 0; i < n; i++) {
            int[] pReachable = {i,m-1};
            avis[i][m-1] = true;
            atlanticQ.offer(pReachable);
        }
        for (int j = 0; j < m; j++) {
            int[] pReachable = {n-1,j};
            avis[n-1][j] = true;
            atlanticQ.offer(pReachable);
        }

        for (int i = 0; i < n; i++) {
            int[] pReachable = {i,0};
            pvis[i][0] = true;
            pacificQ.offer(pReachable);
        }
        for (int j = 0; j < m; j++) {
            int[] pReachable = {0,j};
            pvis[0][j] = true;
            pacificQ.offer(pReachable);
        }

        oceanDfs(pacificQ, heights, pvis);
        oceanDfs(atlanticQ, heights, avis);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(pvis[i][j] && avis[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    private boolean isSafe(int i, int j, int[][] grid) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[i].length){
            return true;
        }
        return false;
    }

    void oceanDfs(Queue<int[]> pacificQ, int[][] heights, boolean[][] pvis){
        int[][] neighbours = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!pacificQ.isEmpty()){

            int[] curr = pacificQ.poll();
            for (int i = 0; i < neighbours.length; i++) {
                int x = curr[0] + neighbours[i][0];
                int y = curr[1] + neighbours[i][1];
                if(isSafe(x,y,heights) && pvis[x][y]==false && heights[x][y]>=heights[curr[0]][curr[1]]){
                    pvis[x][y]=true;
                    int[] reachable = {x,y};
                    pacificQ.offer(reachable);
                }
            }

        }
    }
}
