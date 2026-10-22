class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        dpMax = nums[0]
        dpMin = nums[0]
        maxProduct = nums[0]
        for i in range(1, len(nums)):
            oldMax = dpMax
            oldMin = dpMin
            dpMax = max(oldMax*nums[i], oldMin*nums[i], nums[i])
            dpMin = min(oldMax*nums[i], oldMin*nums[i], nums[i])
            if (dpMax > maxProduct):
                maxProduct = dpMax
        return maxProduct
