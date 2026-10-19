class Solution {
    public int numDecodings(String s) {
        int[][] dp = new int[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new int[s.length()];
        }

        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (j >= s.length())
                    continue;
                if (j == i) {
                    dp[i][j] = s.charAt(i) == '0' ? 0 : 1;
                } else {
                    dp[i][j] = 0;
                    if (s.charAt(i) != '0') {
                        if (i + 1 > j) {
                            dp[i][j] += 1;
                        } else {
                            dp[i][j] += dp[i + 1][j];
                        }
                    }
                    int val = Integer.parseInt(s.substring(i, i + 2));
                    if (val >= 10 && val <= 26) {
                        if (i + 2 > j) {
                            dp[i][j] += 1;
                        } else {
                            dp[i][j] += dp[i + 2][j];
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
