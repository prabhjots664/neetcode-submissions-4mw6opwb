class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        boolean[][] vis = new boolean[100][100];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1' && vis[i][j]==false){
                    gridDfs(i,j,grid,vis);
                    count++;
                }
            }
        }

        return count;
    }

    private boolean satisfyConstraints(int i, int j, char[][] grid){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
    
    private void gridDfs(int i, int j, char[][] grid, boolean[][] vis) {
            vis[i][j]=true;
            
            int[][] child = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int k = 0; k < child.length; k++) {
            int x = i + child[k][0];
            int y = j + child[k][1];
            if(satisfyConstraints(x,y,grid) && grid[x][y]=='1' && vis[x][y]==false){
                gridDfs(x,y,grid,vis);
            }
        }
            
    }
}
