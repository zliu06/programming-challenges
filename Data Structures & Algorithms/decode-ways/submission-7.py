class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * (len(s) + 1)
        dp[len(s)] = 1
        for i in reversed(range(len(s))):
            if int(s[i]) > 0:
                dp[i] += dp[i+1]
            if len(s) - i >= 2 and 10 <= int(s[i:i+2]) <= 26:
                dp[i] += dp[i+2]
        return dp[0]