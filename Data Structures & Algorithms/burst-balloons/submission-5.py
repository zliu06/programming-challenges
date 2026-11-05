class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        values = [1] + nums + [1]
        m = len(values)
        dp = [[0] * m for _ in range(m)]
        for span in range(2, m):
            for i in range(0, m - span):
                j = i + span
                for k in range(i + 1, j):
                    dp[i][j] = max(
                        dp[i][k] + dp[k][j] + values[k] * values[i] * values[j], dp[i][j]
                    )
        return dp[0][m - 1]
