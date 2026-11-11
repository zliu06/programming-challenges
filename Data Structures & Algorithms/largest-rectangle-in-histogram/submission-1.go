func largestRectangleArea(heights []int) int {
	n := len(heights)
	right := make([]int, n)
	left := make([]int, n)
	stack := []int{}

	for i := 0; i < n; i++ {
		right[i] = n - 1
		for len(stack) > 0 {
			p := stack[len(stack) - 1]
			if heights[p] > heights[i] {
				stack = stack[:len(stack)-1]
				right[p] = i-1
			} else {
				break
			}
		}
		stack = append(stack, i)
	}

	stack = stack[:0]
	for i := n-1; i>=0; i-- {
		for len(stack) > 0 {
			p := stack[len(stack) - 1]
			if heights[p] > heights[i] {
				stack = stack[:len(stack)-1]
				left[p] = i + 1
			} else {
				break
			}
		}
		stack = append(stack, i)
	}

	maxArea := 0
	for i := 0; i < n; i++ {
		area := (right[i] - left[i] + 1) * heights[i]
		if area > maxArea {
			maxArea = area
		}
	}

	return maxArea

}
