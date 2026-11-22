import heapq
class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        
        H = len(grid)
        W = len(grid[0])
        heap = []
        heapq.heappush(heap, (0, 0, 0) )
        visited = set()
        visited.add( (0,0,0) )

        directions = [
            (-1, 0, 4),
            (1, 0, 3),
            (0, -1, 2),
            (0, 1, 1),
        ]

        while len(heap) > 0:
            tw, tr, tc = heapq.heappop(heap)

            if tr == H-1 and tc == W-1:
                return tw
            
            for dir in directions:
                nr = tr + dir[0]
                nc = tc + dir[1]

                if 0<= nr < H and 0 <= nc < W:
                    nw = 0 if grid[tr][tc] == dir[2] else 1
                    nw += tw

                    e = (nw, nr, nc)
                    if e not in visited:
                        visited.add(e)
                        heapq.heappush(heap, e)
        return -1


