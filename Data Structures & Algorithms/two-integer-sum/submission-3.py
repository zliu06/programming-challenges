class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        diff = {}
        for i in range(len(nums)):
            diff[nums[i]] = i
        for i in range(len(nums)):
            if target - nums[i] in diff:
                if i != diff[target - nums[i]]:
                    return [i, diff[target - nums[i]]]
        