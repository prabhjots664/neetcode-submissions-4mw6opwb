class Solution {
    

    private boolean isCharGridSafe(int i, int j, char[][] grid) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[i].length){
            return true;
        }
        return false;
    }

    
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                StringBuilder currSb = new StringBuilder();
                if(existBacktrack(board, i, j, word, currSb, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    ///word = "CAT"
    /// board=[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
    /// word="SEE"
    private boolean existBacktrack(char[][] board, int i, int j, String word, StringBuilder currSb, int wordIdx) {
        

        if(board[i][j]!=word.charAt(wordIdx)){
            return false;
        }

        char temp = board[i][j];
        currSb.append(board[i][j]);
        board[i][j]='#';

        if(currSb.toString().equalsIgnoreCase(word)){
            return true;
        }
        
        int[][] children = {{0,1},{1,0}, {0, -1}, {-1, 0}};
        for (int k = 0; k < children.length; k++) {
            int x = i+children[k][0];
            int y = j+children[k][1];
            if(isCharGridSafe(x, y, board) && board[x][y]!='#' && wordIdx+1<word.length() && board[x][y]==word.charAt(wordIdx+1)){
                
                boolean wordExists = existBacktrack(board, x, y, word, currSb, wordIdx+1);
                
                if(wordExists){
                    return true;
                }
            }
        }

        board[i][j] = temp;
        currSb.deleteCharAt(currSb.length()-1);
        return false;
    }
    
}
