class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals("1")) {
                    explore(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }

    class DFS {
        int[][] DIRECTIONS = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        void explore(char[][] grid, int row, int col) {
            if (row<0||row >= grid.length) return;
            if (col<0||col>=grid[0].length) return;
            if ("1".equals(grid[row][col])) {
                grid[row][col]="#";
                for (int i = 0; i<DIRECTIONS.length;i++) {
                    int[] dir = DIRECTIONS[i];
                    int r = row+dir[0];
                    int c = col+dir[1];
                    explore(grid,r,c);
                }
            }
        }
    }
}
