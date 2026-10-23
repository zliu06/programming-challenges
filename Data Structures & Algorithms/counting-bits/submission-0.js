class Solution {
    /**
     * @param {number} n
     * @return {number[]}
     */
    countBits(n) {
        const dp = new Array(n + 1).fill(0);
        let nextOffset = 1;
        for (let i = 1; i <= n; i++) {
            if (i < nextOffset) {
                dp[i] = 1 + dp[i - Math.floor(nextOffset / 2)];
            } else if (i == nextOffset) {
                dp[i] = 1;
                nextOffset = nextOffset * 2;
            }
        }
        return dp;
    }
}
