class Solution {
    private boolean isSafe(int i, int j, int[][] grid) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[i].length){
            return true;
        }
            return false;
    }

     public int orangesRotting(int[][] grid) {

        int countFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    int[] rotten = {i,j};
                    q.offer(rotten);
                }
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        int[] delimiter = {-1,-1};
        q.offer(delimiter);

        int minutes = 0;
        int[][] neighbours = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!q.isEmpty()){
            int[] rotten = q.poll();
            if(rotten[0]==-1){ // delimiter case
                if(!q.isEmpty()){
                    q.offer(delimiter);
                }
                minutes++;
            } else {

                for (int i = 0; i < neighbours.length; i++) {
                    int x = rotten[0] + neighbours[i][0];
                    int y = rotten[1] + neighbours[i][1];
                    if(isSafe(x,y,grid) && grid[x][y]==1){
                        int[] fresh = {x,y};
                        countFresh--;
                        grid[x][y]=2;//rot the fresh ones
                        q.offer(fresh);
                    }
                }

            }
        }

        if(countFresh!=0) return -1;
        return minutes>0 ? minutes-1 : 0;
    }
}
