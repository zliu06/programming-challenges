class Solution {
    /**
     * @param {character[][]} grid
     * @return {number}
     */
    numIslands(grid) {
        let count = 0;
        for (let i = 0; i < grid.length; i++) {
            for (let j = 0; j < grid[0].length; j++) {
                if (grid[i][j] === "1") {
                    this.dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    dfs(grid, row, col) {
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;
        if (grid[row][col] === "1") {
            grid[row][col] = "#";
            this.dfs(grid, row + 1, col);
            this.dfs(grid, row - 1, col);
            this.dfs(grid, row, col + 1);
            this.dfs(grid, row, col - 1);
        }
    }
}
