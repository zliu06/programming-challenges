func findCircleNum(isConnected [][]int) int {
	provinces := 0
	n := len(isConnected)
	visited := make([]int, n)
	var dfs func(int)

	dfs = func(node int) {
		if visited[node] == 1 {
			return
		}
		visited[node] = 1
		for i := 0; i < n; i++ {
			if i == node {
				continue
			}
			if isConnected[node][i] == 1 {
				dfs(i)
			}
		}
	}

	for i:= 0; i < n; i++ {
		if visited[i] == 0 {
			dfs(i)
			provinces += 1
		}
	}

	return provinces
}
