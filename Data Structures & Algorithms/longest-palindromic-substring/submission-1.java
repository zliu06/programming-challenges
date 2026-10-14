class Solution {
    public String longestPalindrome(String s) {
        
        int first = 0;
        int last = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            // odd length
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if ((r-l+1) > maxLength) {
                    maxLength = (r-l+1);
                    first = l;
                    last = r;
                }
                l--;
                r++;
            }
            // even length
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if ((r-l+1) > maxLength) {
                    maxLength = (r-l+1);
                    first = l;
                    last = r;
                }
                l--;
                r++;
            }
        }

        return s.substring(first, last+1);
    }
}
