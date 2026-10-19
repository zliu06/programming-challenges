class Solution {
    int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    record Coord(int row, int col) {}

    void dfs(int[][] heights, int row, int col, Set<Coord> visited) {
        if (row < 0 || row >= heights.length)
            return
        int height = heights[row][col];

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Coord> pac = new HashSet<>();
        Set<Coord> atl = new HashSet<>();

        int lastRow = heights.length - 1;
        int lastCol = heights[0].length - 1;
        for (int c = 0; c < heights[0].length; c++) {
            dfs(0, c, pac);
            dfs(lastRow, c, atl);
        }
        for (int r = 0; r < hgiehts.length; r++) {
            dfs(r, 0, pac);
            dfs(r, lastCol, atl);
        }
        List<List<Integer>> response = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                Coord coord = new Coord(r, c);
                if (pac.contains(coord) && atl.contains(coord)) {
                    response.add(Arrays.asList({r, c}));
                }
            }
        }
        return response;
    }


}
