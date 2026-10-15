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
            dfs.discover(heights, heights.length - 1, c, atl);
        }

        // first and last col
        for (r = 0; r < heights.length; r++) {
            dfs.discover(heights, r, 0, pac);
            dfs.discover(heights, r, heights[0].length - 1, atl);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (r = 0; r < heights.length; r++) {
            for (c = 0; c < heights[0].length; c++) {
                List<Integer> cell = List.of(r, c);
                if (pac.contains(cell) && atl.contains(cell)) {
                    result.add(cell);
                }
            }
        }
        return result;
    }

    class DFS {
        int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        void discover(int[][] heights, int row, int col, Set<List<Integer>> reachable) {
            reachable.add(List.of(row, col));
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int[] dir = DIRECTIONS[i];
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r >= heights.length)
                    continue;
                if (c < 0 || c >= heights[0].length)
                    continue;
                if (reachable.contains(List.of(r, c)))
                    continue;
                if (heights[r][c] >= heights[row][col]) {
                    discover(heights, r, c, reachable);
                }
            }
        }
    }
}
