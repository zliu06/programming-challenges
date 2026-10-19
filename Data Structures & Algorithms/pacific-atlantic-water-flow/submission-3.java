class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        DFS dfs = new DFS();
        int r;
        int c;
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        // first row and last row
        for (c = 0; c < heights[0].length; c++) {
            dfs.discover(heights, 0, c, pac);
        }
    }

    class DFS
    {
        int[][] DIRECTIONS = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        void discover(int[][] heights, int row, int col, Set<List<Integer>> reachable) {
            if (row < 0 || row >= heights.length) return;
            if (col < 0 || col >= heights[0].length) return;
            if (reachable.contains(List.of(row, col))) return;
            reachable.add(List.of(row, col));
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int[] dir = DIRECTIONS[i];
                int r = row + dir[0];
                int c = col + dir[1];
                if (heights[r][c] >= heights[row][col]) {
                    discover(heights, r, c, reachable);
                }
            }
        }
    }
}
