class Solution {

    record Cell(int row, int col) {}

    public int numIslands(char[][] grid) {
        Set<Cell> visited = new HashSet<>();
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Cell current = new Cell(i, j);
                if (grid[i] == "1" && !visited.contains(current)) {
                    bfs(grid, visited, current);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    void bfs(char[] grid, Set<Cell> visited, Cell focus) {
        Queue<Cell> queue = new ArrayDeque<>();
        int row = focus.row();
        int col = focus.col();

        int[][] dirs = new int[] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };j

        if (grid[row][col] == "1") {
            visited.add(focus);

            queue.offer(focus);

            while (!queue.isEmpty()) {
                Cell pt = queue.poll();
                for (int i = 0; i < dirs.length; i++) {
                    Cell neuve = new Cell(pt.row() + dirs[i][0], pt.col() + dirs[i][1]);
                    if (grid[neuve.row()][neuve.col()].equals("1"))
                }
            }
        }
    }
}
