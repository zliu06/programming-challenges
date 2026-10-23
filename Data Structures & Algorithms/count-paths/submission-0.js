class Solution {
    /**
     * @param {number} m
     * @param {number} n
     * @return {number}
     */
    uniquePaths(m, n) {
        const dp = Array.from({length: m}, ()=>new Array(n));
        for (let i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (let i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (let r = 1; r < m; r++) {
            for (let c = 1; c < n; c++) {
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }
        return dp[m-1][n-1];
    }
}
