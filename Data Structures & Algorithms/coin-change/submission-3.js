class Solution {
    /**
     * @param {number[]} coins
     * @param {number} amount
     * @return {number}
     */
    coinChange(coins, amount) {
        const dp = new Array(amount+1).fill(Infinity);
        dp[0] = 0;
        for (let i = 1; i <= amount; i++) {
            for (let denom of coins) {
                if (denom <= i) {
                    dp[i] = Math.min(dp[i], 1+dp[i-denom]);
                }
            }
        }
        if (dp[amount] === Infinity) return -1;
        return dp[amount];
    }
}
