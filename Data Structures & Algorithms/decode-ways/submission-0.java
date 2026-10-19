class Solution {
    public int numDecodings(String s) {
        int[][] dp = new int[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new int[s.length()];
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) {
                    dp[i][j] = s.charAt(i) == '0' ? 0 : 1;
                } else if (j == i + 1) {
                    dp[i][j] = 0;
                    if (s.charAt(i) != '0') {
                        dp[i][j] += 1 * dp[j][j];
                    }
                    int val = Integer.parseInt(s.substring(i, j + 1));
                    if (val >= 10 && val <= 26) {
                        dp[i][j] += 1;
                    }
                } else {
                    dp[i][j] = 0;
                    if (s.charAt(i) != '0') {
                        dp[i][j] += 1 * dp[i + 1][j];
                    }
                    int val = Integer.parseInt(s.substring(i, j + 1));
                    if (val >= 10 && val <= 26) {
                        dp[i][j] += 1 * dp[i + 2][j];
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
