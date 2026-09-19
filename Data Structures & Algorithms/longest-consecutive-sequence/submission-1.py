class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)

        longest_length = 0

        for num in nums:
            if (num-1) in num_set:
                continue
            sequence_begin = num
            sequence_end = num
            while sequence_end in num_set:
                sequence_end += 1
            sequence_length = sequence_end - sequence_begin
            if sequence_length > longest_length:
                longest_length = sequence_length
        return longest_length