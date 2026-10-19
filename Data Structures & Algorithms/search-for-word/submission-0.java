class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, r, c, word, 0)) return true;
            }
        }
        return false;
    }

    int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    }; 

    boolean dfs(char[][] board, int row, int col, String word, int next) {
        if (next == word.length()) return true;
        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[0].length) return false;
        Character ch = board[row][col];
        if (ch == word.chatAt(next)) {
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int[] dir = DIRECTIONS[i];
                int r = row + dir[0];
                int c = col + dir[1];
                if (dfs(board, r, c, word, next+1)) return true;
            }
        }
        return false;
    }
}
