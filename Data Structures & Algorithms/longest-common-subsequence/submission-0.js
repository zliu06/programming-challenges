class Solution {
    /**
     * @param {string} text1
     * @param {string} text2
     * @return {number}
     */
    longestCommonSubsequence(text1, text2) {
        const dp = Array.from({ length: text1.length }, () => new Array(text2.length));
        dp[0][0] = text1[0] === text2[0]? 1 : 0;
        for (let i = 1; i < text2.length; i++) {
            dp[0][i] = dp[0][i - 1];
            if (text2[i] === text1[0]) {
                dp[0][i] = 1;
            }
        }
        for (let i = 1; i < text1.length; i++) {
            dp[i][0] = dp[i - 1][0];
            if (text1[i] === text2[0]) {
                dp[i][0] = 1;
            }
        }
        for (let i = 1; i < text1.length; i++) {
            for (let j = 1; j < text2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1[i] === text2[j]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[text1.length - 1][text2.length - 1];
    }
}
