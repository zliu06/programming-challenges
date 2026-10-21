class Solution {
    /**
     * @param {string} s
     * @param {string[]} wordDict
     * @return {boolean}
     */
    wordBreak(s, wordDict) {
        const dp = new Array(s.length);
        dp.fill(false);

        for (let i = s.length - 1; i >= 0; i--) {
            for (let word of wordDict) {
                if (word.length <= s.length - i) {
                    if (this.isPrefixOf(word, s, i, s.length - 1)) {
                        if (i + word.length < s.length)
                            dp[i] = dp[i] || dp[i + word.length];
                        else
                            dp[i] = true;
                    }
                }
            }
        }

        return dp[0];
    }

    isPrefixOf(word, s, begin, end) {
        for (let i = 0; i < word.length; i++) {
            if (begin + i > end) return false;
            if (word[i] !== s[begin + i]) return false;
        }
        return true;
    }
}
