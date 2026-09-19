class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)

        longest_length = 0

        for num in num_set:
            if (num-1) in num_set:
                continue
            curr = num
            while curr in num_set:
                curr += 1
            sequence_length = curr - num
            longest_length = max(sequence_length, longest_length)
        return longest_length