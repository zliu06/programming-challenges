class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for i in range(0, len(nums)):
            tmp = abs(nums[i])
            if nums[tmp] < 0:
                return tmp
            nums[tmp] *= -1