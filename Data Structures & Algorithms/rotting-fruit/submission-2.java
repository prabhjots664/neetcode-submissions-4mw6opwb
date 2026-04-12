class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    int[] rotten = {i,j};
                    q.offer(rotten);
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        int[] delimiter = {-1,-1};
        q.offer(delimiter);

        int time = 0;
        int[][] children = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] rotten = q.poll();
            if(rotten[0]==-1){
                if(q.isEmpty()){
                    break;
                } else {
                    q.offer(delimiter);
                    time++;
                }
            } else {
                for(int i =0;i<4;i++){
                    int x = rotten[0] + children[i][0];
                    int y = rotten[1] + children[i][1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                        freshCount--;
                        grid[x][y] = 2;
                        int[] newRotten = {x,y};
                        q.offer(newRotten);
                    }
                }
            }
        }

        return freshCount==0 ? time:-1;
    }
}
