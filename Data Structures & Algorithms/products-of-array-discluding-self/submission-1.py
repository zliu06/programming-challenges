class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        length = len(nums)
        prefix = [1] * length
        suffix = [1] * length
        ans = [0] * length

        for i in range(1, length, 1):
            prefix[i] = prefix[i-1] * nums[i-1]
        
        for i in reversed(range(length - 1)):
            suffix[i] = suffix[i+1] * nums[i+1]
        
        for i in range(length):
            ans[i] = prefix[i] * suffix[i]
        
        return ans