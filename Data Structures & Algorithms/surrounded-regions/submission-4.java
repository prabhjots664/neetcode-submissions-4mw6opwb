class Solution {
    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] vis = new boolean[board.length][board[0].length];
                if(board[i][j]=='O' && charDfs(board, i, j, false, vis)){
                    vis = new boolean[board.length][board[0].length];
                    charDfs(board, i, j, true, vis);
                }
            }
        }

    }

    boolean charDfs(char[][] board, int i, int j, boolean mark, boolean[][] vis){
        if(i==0 || i== board.length-1 || j==0 || j== board[0].length-1){
            return false;
        }
        int[][] neighbours = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean res = true;
        vis[i][j] = true;
        if(mark){
            board[i][j]='X';
        }
        for (int k = 0; k < neighbours.length; k++) {
            int x = i + neighbours[k][0];
            int y = j + neighbours[k][1];
            if(isCharGridSafe(x,y,board) && vis[x][y]==false && board[x][y]=='O'){
                res = res && charDfs(board, x, y , mark, vis);
            }
        }
        
        return res;
    }

    private boolean isCharGridSafe(int i, int j, char[][] grid) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[i].length){
            return true;
        }
        return false;
    }
}
