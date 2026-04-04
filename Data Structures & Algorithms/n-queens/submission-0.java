class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDia = new HashSet<>();
    Set<Integer> negDia = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i],'.');
        }
        backtrack(0, n, board);
        return res;
    }
    
    void backtrack(int r, int n, char[][] board){
        if(r==n){
            List<String> resList = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String str = "";
                for (int j = 0; j < board.length; j++) {
                        str += board[i][j];
                }
                resList.add(str);
            }
            res.add(resList);
        }
        
        for (int c = 0; c < board.length; c++) {
            if(col.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)){
                continue;
            }
            
            col.add(c); posDia.add(r+c); negDia.add(r-c);
            board[r][c]='Q';
            backtrack(r+1, n, board);
            col.remove(c); posDia.remove(r+c); negDia.remove(r-c);
            board[r][c]='.';
        }
        
        
    }
}
