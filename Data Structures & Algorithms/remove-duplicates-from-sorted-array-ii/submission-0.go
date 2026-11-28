func removeDuplicates(nums []int) int {
	N := len(nums)
	i := 1
	j := 1
	for i < N {
		if nums[i] == nums[i-1] {
			nums[j] = nums[i]
			for i < N && nums[i] == nums[j] {
				i++
			}
			j++
		} else {
			nums[j] = nums[i]
			i++
			j++
		}
	}
	return j
}