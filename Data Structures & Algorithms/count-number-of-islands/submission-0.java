class Solution {

    record Cell(int row, int col) {}

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;

        Set<Cell> visited = new HashSet<>();
        int numOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[] cell = { i, j };
                if (grid[i][j] == '1'
                     && !visited.contains(new Cell(cell[0], cell[1]))) {
                    bfs(grid, cell, visited);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;

    }

    private void bfs(
        char[][] grid,
        int[] cell, 
        Set<Cell> visited)
    {
        Queue<int[]> toBeExpanded = new ArrayDeque<>();
        List<int[]> directions = Arrays.asList(
            new int[] {-1,0},
            new int[] {1,0},
            new int[] {0,-1},
            new int[] {0,1}
        );
        visited.add(new Cell(cell[0], cell[1]));

        toBeExpanded.offer(cell);

        while (!toBeExpanded.isEmpty()) {
            int[] c = toBeExpanded.poll();
            for (int[] d: directions) {
                int[] n = new int[] {
                    c[0] + d[0],
                    c[1] + d[1]
                };
                if (!(n[0] >= 0 && n[0] < grid.length)) {
                    continue;
                }
                if (!(n[1] >= 0 && n[1] < grid[0].length)) {
                    continue;
                }
                if (grid[n[0]][n[1]] == '0')
                    continue;
                if (visited.contains(new Cell(n[0], n[1]))) {
                    continue;
                }
                visited.add(new Cell(n[0], n[1]));
                toBeExpanded.offer(n);
            }
        }
    }
}
