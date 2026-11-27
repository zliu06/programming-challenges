func minEatingSpeed(piles []int, h int) int {
	left := 1
	right := 1
	for _, p := range piles {
		if p > right {
			right = p
		}
	}
	for left < right {
		mid := left + (right - left) / 2
		t := 0
		for _, p := range piles {
			t += p / mid
			if p % mid != 0 {
				t += 1
			}
		}
		if t > h {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return left
}
