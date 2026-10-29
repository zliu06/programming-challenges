class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixSum = [nums[0]]
        for i in range(1, len(nums)):
            prefixSum.append(prefixSum[i - 1] + nums[i])
        sumToCount = {}
        sumToCount[0] = 1
        result = 0
        for i in range(len(nums)):
            if i >= 1:
                sumToCount[prefixSum[i - 1]] = sumToCount.get(prefixSum[i - 1], 0) + 1
            key = prefixSum[i] - k
            if key in sumToCount:
                result += sumToCount[key]
        return result
