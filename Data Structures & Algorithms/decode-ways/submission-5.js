class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    numDecodings(s) {
        const dp = new Array(s.length + 2);
        dp.fill(0);
        dp[s.length] = 1;
        dp[s.length + 1] = 1;
        for (let i = s.length - 1; i >= 0; i--) {
            if (s[i] === "0") continue;
            dp[i] += dp[i + 1];
            if (i <= s.length - 2) {
                const number = parseInt(s.slice(i, i + 2), 10);
                if (number <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
