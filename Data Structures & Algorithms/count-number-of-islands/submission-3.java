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
                if (grid[i][j] == '1' && !visited.contains(current)) {
                    bfs(grid, visited, current);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    void bfs(char[][] grid, Set<Cell> visited, Cell focus) {
        Queue<Cell> queue = new ArrayDeque<>();
        int row = focus.row();
        int col = focus.col();

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        if (grid[row][col] == '1') {
            visited.add(focus);

            queue.offer(focus);

            while (!queue.isEmpty()) {
                Cell pt = queue.poll();
                for (int i = 0; i < dirs.length; i++) {
                    Cell neighbor = new Cell(pt.row() + dirs[i][0], pt.col() + dirs[i][1]);

                    if (neighbor.row() < 0 
                    || neighbor.col() < 0
                    || neighbor.row() >= grid.length
                    || neighbor.col() >= grid[0].length) {
                        continue;
                    }

                    if (grid[neighbor.row()][neighbor.col()] == '1') {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }


        }
    }
}
