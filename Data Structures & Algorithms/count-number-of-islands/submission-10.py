class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        result = 0

        def dfs(grid, row, col):
            if row < 0 or row >= len(grid):
                return
            if col < 0 or col >= len(grid[0]):
                return
            if grid[row][col] == "0":
                return
            if grid[row][col] == "#":
                return
            grid[row][col] = "#"
            dfs(grid, row + 1, col)
            dfs(grid, row - 1, col)
            dfs(grid, row, col + 1)
            dfs(grid, row, col - 1)

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == "1":
                    dfs(grid, r, c)
                    result += 1
        return result
