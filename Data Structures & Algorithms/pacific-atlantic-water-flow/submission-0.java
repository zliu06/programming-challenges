class Solution {

    record Cell(int row, int col) {}

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        Set<Cell> pac = new HashSet<>();
        Set<Cell> atl = new HashSet<>();

        for (int i = 0; i < COLS; i++) {
            dfs(heights, new Cell(0, i), pac);
            dfs(heights, new Cell(ROWS-1, i), atl);
        }

        for (int i = 0; i < ROWS; i++) {
            dfs(heights, new Cell(i, 0), pac);
            dfs(heights, new Cell(i, COLS-1), atl);
        }

        List<List<Integer>> response = new ArrayList<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Cell c = new Cell(i, j);
                if (pac.contains(c) && atl.contains(c)) {
                    response.add(Arrays.asList(i, j));
                }
            }
        }

        return response;
    }

    void dfs(int[][] heights, Cell c, Set<Cell> visited) {

        int ROWS = heights.length;
        int COLS = heights[0].length;

        visited.add(c);

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        for (int i = 0; i < dirs.length; i++) {
            Cell neighbor = new Cell(c.row()+dirs[i][0], c.col()+dirs[i][1]);
            int row = neighbor.row();
            int col = neighbor.col();
            if (row < 0 || col < 0 || row >= ROWS || col >= COLS) {
                continue;
            }
            if (visited.contains(neighbor)) {
                continue;
            }
            if (heights[row][col] < heights[c.row()][c.col()]) {
                continue;
            }
            dfs(heights, neighbor, visited);
        }
    }
}
