type Cell struct {
	height int
	row int
	col int
}

type Position struct {
	row int
	col int
}

type MinHeap []Cell

func (h MinHeap) Len() int {
	return len(h)
}

func (h MinHeap) Less(i, j int) bool {
	return h[i].height < h[j].height
}

func (h MinHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *MinHeap) Push(x any) {
	*h = append(*h, x.(Cell))
}

func (h *MinHeap) Pop() any {
	old := *h
	last := len(old) - 1
	item := old[last]
	*h = old[:last]
	return item
}

func swimInWater(grid [][]int) int {
		
	directions := [4][2]int {
		{-1, 0},
		{0, 1},
		{0, -1},
		{1, 0},
	}
	
	h := &MinHeap{}
	visited := make(map[Position]bool)

	heap.Init(h)

	length := len(grid)
	if length == 1 {
		return grid[0][0]
	}

	hh := grid[0][0]
	heap.Push(h, Cell{height: hh, row: 0, col: 0})
	visited[Position{row: 0, col: 0}] = true

	for len(*h) > 0 {
		top := heap.Pop(h).(Cell)

		tr := top.row
		tc := top.col

		for _, dir := range directions {
			nr := tr + dir[0]
			nc := tc + dir[1]

			if nr >= 0 && nr < length && nc >= 0 && nc < length {
				if !visited[Position{row: nr, col: nc}] {
					nh := max(top.height, grid[nr][nc])
					if nr == length - 1 && nc == length - 1 {
						return nh
					}
					visited[Position{row: nr, col: nc}] = true
					heap.Push(h, Cell{height: nh, row: nr, col: nc})
				}
			}
		}
	}

	return -1
}
