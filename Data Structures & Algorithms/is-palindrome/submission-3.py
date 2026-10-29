class Solution:
    def isPalindrome(self, s: str) -> bool:
        def isAlphaNumeric(ch):
            return (
                "A" <= ch <= "Z"
                or "a" <= ch <= "z"
                or "0" <= ch <= "9"
            )
        left = 0
        right = len(s) - 1
        while left < right:
            while left < len(s) and not isAlphaNumeric(s[left]):
                left += 1
            if left >= len(s):
                return True
            while not isAlphaNumeric(s[right]):
                right -= 1
            if left <= right:
                # print(f"left={left}, right={right}, s[left]={s[left]}, s[right]={s[right]}")
                if s[left].lower() != s[right].lower():
                    return False
                left += 1
                right -= 1
        return True
            
