class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        q = []
        visited = set()
        heapq.heappush(q, (grid[0][0], 0, 0))
        N = len(grid)

        if N == 1:
            return grid[0][0]

        while len(q) > 0:
            head = heapq.heappop(q)
            h0, r0, c0 = head

            for r, c in [(r0 - 1, c0), (r0 + 1, c0), (r0, c0 - 1), (r0, c0 + 1)]:
                if r >= 0 and r < N and c >= 0 and c < N:
                    h = max(h0, grid[r][c])
                    if r == N - 1 and c == N - 1:
                        return h
                    if not (r, c) in visited:
                        visited.add((r, c))
                        heapq.heappush(q, (h, r, c))

        return None
