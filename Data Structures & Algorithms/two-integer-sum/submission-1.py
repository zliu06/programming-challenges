class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        revert_index = {}

        for loc, val in enumerate(nums):
            complement = target - val
            if complement in revert_index:
                return [revert_index[complement], loc]
            revert_index[val] = loc
        
        return []