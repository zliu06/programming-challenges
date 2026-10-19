class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index = {}
        for loc, val in enumerate(nums):
            index[val] = loc
        
        for loc, val in enumerate(nums):
            complement = target - val
            if complement in index:
                return [loc, index[complement]]
        
        return []