class Solution {
    public String longestPalindrome(String s) {
        int [][] palindrome = new int[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            palindrome[i] = new int[s.length()];
        }

        int first = 0;
        int last = 0;
        int maxLength = 1;

        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < (s.length()+1-len); i++) {
                int l = i;
                int r = l+len-1;
                if (len == 1) {
                    palindrome[l][r] = 1;
                }
                else if (len == 2) {
                    palindrome[l][r] = s.charAt(r) == s.charAt(l)?1:0;
                }
                else {
                    palindrome[l][r] = (s.charAt(r) == s.charAt(l))? palindrome[l+1][r-1]:0;
                }
                
                if (palindrome[l][r] == 1) {
                    maxLength = r-l+1;
                    first = l;
                    last = r;
                }
            }
        }

        return s.substring(first,last+1);
    }
}
