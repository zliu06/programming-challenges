class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        maxLength = 0
        for num in nums:
            if (num - 1) not in numSet:
                begin = num
                end = begin
                while end in numSet:
                    end += 1
                length = end - begin
                if length > maxLength:
                    maxLength = length
        return maxLength
        