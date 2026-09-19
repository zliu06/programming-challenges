class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        tmp = nums[0]

        while True:
            if tmp == nums[tmp]:
                return tmp
            next = nums[tmp]
            nums[tmp] = tmp
            tmp = next