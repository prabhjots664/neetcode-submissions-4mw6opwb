class Solution {
    private boolean isSafe(int i, int j, int[][] grid) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[i].length){
            return true;
        }
            return false;
    }
    
    public void islandsAndTreasure(int[][] grid) {

        int INF = 2147483647;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==0){
                    int[] treasure = {i,j};
                    q.offer(treasure);
                }
            }
        }
        int[][] children = {{0,1},{1,0},{0,-1},{-1,0}};
        int level;

        while (!q.isEmpty()){
            int[] curr = q.poll();
            level = grid[curr[0]][curr[1]] + 1;
            for (int i = 0; i < children.length; i++) {
                int x = curr[0]+children[i][0];
                int y = curr[1]+children[i][1];
                if(isSafe(x,y,grid) && grid[x][y]==INF ){
                    grid[x][y]=level;
                    int[] dis = {x,y};
                    q.offer(dis);
                }
            }
        }

    }
}
