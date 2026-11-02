class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            pairs = ["()", "[]", "{}"]
            for pair in pairs:
                if s[i] in pair:
                    if s[i] == pair[0]:
                        stack.append(s[i])
                    elif len(stack) > 0 and stack[-1] == pair[0]:
                        stack.pop()
                    else:
                        stack.append(s[i])
        return len(stack) == 0
