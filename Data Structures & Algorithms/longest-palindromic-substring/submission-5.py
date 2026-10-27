class Solution:
    def longestPalindrome(self, s: str) -> str:
        max_length = 0
        begin = 0
        end = 0

        for i in range(len(s)):
            ch = s[i]

            # odd length
            left = i
            right = i
            while left >= 0 and right < len(s):
                if s[left] == s[right]:
                    if (right - left + 1) > max_length:
                        max_length = right - left + 1
                        begin = left
                        end = right
                    left -= 1
                    right += 1
                else:
                    break

            left = i
            right = i + 1
            while left >= 0 and right < len(s):
                if s[left] == s[right]:
                    if (right - left + 1) > max_length:
                        max_length = right - left + 1
                        begin = left
                        end = right
                    left -= 1
                    right += 1
                else:
                    break

        return s[begin : end + 1]
