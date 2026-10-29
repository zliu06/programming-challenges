class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        i = 0
        while i < len(nums):
            t = -nums[i]
            j = i + 1
            k = len(nums) - 1
            while j < k:
                s = nums[j] + nums[k]
                if s < t:
                    j += 1
                elif s > t:
                    k -= 1
                else:
                    triplet = [nums[i], nums[j], nums[k]]
                    result.append(triplet)
                    while j < k and nums[j] == triplet[1]:
                        j += 1
                    while j < k and nums[k] == triplet[2]:
                        k -= 1
            j = i
            while j < len(nums) and nums[j] == nums[i]:
                j += 1
            i = j
        return result
