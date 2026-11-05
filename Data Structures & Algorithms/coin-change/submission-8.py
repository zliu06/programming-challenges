class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0
        for a in range(1, amount + 1):
            for coin in coins:
                if a >= coin:
                    dp[a] = min(dp[a], 1 + dp[a - coin])
        return -1 if dp[amount] == float("inf") else dp[amount]
