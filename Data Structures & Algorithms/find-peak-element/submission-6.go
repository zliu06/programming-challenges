func findPeakElement(nums []int) int {
	N := len(nums)
	left := 0
	right := N
	mid := 0
	for left < right {
		mid = left + (right - left) / 2
		if mid < (N - 1) && nums[mid] < nums[mid+1] {
			left = mid + 1
		} else if mid > 0 && nums[mid] < nums[mid - 1] {
			right = mid-1
		} else {
			return mid
		}
	}
	return right
}
