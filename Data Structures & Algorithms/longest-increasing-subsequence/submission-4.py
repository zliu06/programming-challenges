class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        def lowerBound(seq, begin, end, target):
            left = begin
            right = end
            while left < right:
                mid = left + (right - left) // 2
                if seq[mid] < target:
                    left = mid + 1
                elif seq[mid] > target:
                    right = mid
                else:
                    right = mid
            return left

        endings = [nums[0]]
        for i in range(1, len(nums)):
            index = lowerBound(endings, 0, len(endings), nums[i])
            if index < len(endings):
                endings[index] = nums[i]
            else:
                endings.append(nums[i])
        return len(endings)
