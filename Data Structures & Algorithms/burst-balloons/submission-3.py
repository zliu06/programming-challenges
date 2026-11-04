class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        vals = [1] + nums + [1]
        m = len(vals)
        dp = [[0] * m for _ in range(m)]
        for span in range(2, len(nums) + 2):
            for i in range(0, m - span):
                j = i + span
                # if span == 2:
                #     dp[i][j] = vals[i] * vals[i + 1] * vals[j]
                # else:
                for k in range(i + 1, j):
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + vals[k] * vals[i] * vals[j])
        return dp[0][m - 1]
