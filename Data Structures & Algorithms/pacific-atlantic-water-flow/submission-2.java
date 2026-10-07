class Solution {
    int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    record Coord(int row, int col) {}

    void dfs(int[][] heights, int row, int col, Set<Coord> visited) {
        visited.add(new Coord(row, col));
        int height = heights[row][col];
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int[] dir = DIRECTIONS[i];
            int r = row + dir[0];
            int c = col + dir[1];
            if (r < 0 || r >= heights.length)
                continue;
            if (c < 0 || c >= heights[0].length)
                continue;
            if (visited.contains(new Coord(r, c)))
                continue;
            if (heights[r][c] < height)
                continue;
            dfs(heights, r, c, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Coord> pac = new HashSet<>();
        Set<Coord> atl = new HashSet<>();

        int lastRow = heights.length - 1;
        int lastCol = heights[0].length - 1;
        for (int c = 0; c < heights[0].length; c++) {
            dfs(heights, 0, c, pac);
            dfs(heights, lastRow, c, atl);
        }
        for (int r = 0; r < heights.length; r++) {
            dfs(heights, r, 0, pac);
            dfs(heights, r, lastCol, atl);
        }
        List<List<Integer>> response = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                Coord coord = new Coord(r, c);
                if (pac.contains(coord) && atl.contains(coord)) {
                    response.add(Arrays.asList(r, c));
                }
            }
        }
        return response;
    }


}
