class Solution:
    def rob(self, nums: List[int]) -> int:
        def maxAmount(nums, begin, end):
            dp = [0] * (end - begin + 1)
            for i in reversed(range(end - begin + 1)):
                dp[i] = nums[begin+i]
                if i + 2 < len(dp):
                    dp[i] += dp[i + 2]
                if i + 1 < len(dp):
                    dp[i] = max(dp[i], dp[i + 1])
            return dp[0]

        if len(nums) < 2:
            return nums[0]
        return max(maxAmount(nums, 0, len(nums) - 2), maxAmount(nums, 1, len(nums) - 1))
