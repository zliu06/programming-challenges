class Solution {
    public String longestPalindrome(String s) {
        int l;
        int r;
        int maxLength = 1;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len > maxLength) {
                    maxLength = len;
                    begin = l;
                    end = r;
                }
                l--;
                r++;
            }
            // even length
            l=i;
            r=i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len > maxLength) {
                    maxLength = len;
                    begin = l;
                    end = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(begin, end+1);
    }
}
