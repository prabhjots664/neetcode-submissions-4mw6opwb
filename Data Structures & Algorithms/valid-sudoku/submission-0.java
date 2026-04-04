class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowSets = new ArrayList<>();
        List<Set<Character>> colSets = new ArrayList<>();
        List<Set<Character>> boxSets = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
            boxSets.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(Character.isDigit(board[i][j])){
                    Set<Character> row = rowSets.get(i);
                    Set<Character> col = colSets.get(j);
                    int boxnumber = (i/3)*3 + (j/3); // 4, 8
                    Set<Character> box = boxSets.get(boxnumber);

                    if(row.contains(board[i][j]) || col.contains(board[i][j]) || box.contains(board[i][j])){
                        return false;
                    }
                    row.add(board[i][j]);
                    col.add(board[i][j]);
                    box.add(board[i][j]);
                }
            }
        }


        return true;
    }
}
