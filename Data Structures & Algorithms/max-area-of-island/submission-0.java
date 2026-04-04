class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        boolean[][] vis = new boolean[55][55];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1 && vis[i][j]==false){
                    int val = dfsVal(grid, vis, i , j);
                    if(max<val){
                        max = val;
                    }
                }
            }
        }

        return max;
    }

    private int dfsVal(int[][] grid, boolean[][] vis, int i, int j) {

        vis[i][j]=true;
        int res = 1;
        int[][] childs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int k = 0; k < childs.length; k++) {
             int i1= i+childs[k][0];
             int j1 = j+childs[k][1];
             if(isSafe(i1,j1, grid) && grid[i1][j1]==1 && vis[i1][j1]==false){
                 res += dfsVal(grid, vis, i1, j1);
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
}
