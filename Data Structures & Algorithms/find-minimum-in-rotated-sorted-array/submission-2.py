class Solution:
    def findMin(self, nums: List[int]) -> int:

        def search(nums):
            left = 0
            right = len(nums)
            while left < right:
                mid = left + (right - left) // 2
                if mid - 1 < 0:
                    return nums[mid]
                elif nums[mid] < nums[mid - 1]:
                    return nums[mid]
                elif nums[mid] > nums[mid - 1]:
                    if nums[mid] > nums[0]:
                        # right side
                        left = mid + 1
                    else:
                        right = mid
            return nums[0]

        return search(nums)