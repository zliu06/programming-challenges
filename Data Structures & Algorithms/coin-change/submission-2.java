class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int denom : coins) {
                if (denom <= i) {
                    if (dp[i - denom] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], 1 + dp[i - denom]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
