class Solution:
    def encode(self, strs: List[str]) -> str:
        result = []
        for word in strs:
            result.append(str(len(word)) + "#" + word)
        return "".join(result)

    def decode(self, s: str) -> List[str]:
        result = []
        begin = 0
        while begin < len(s):
            end = begin + 1
            while end < len(s):
                if s[end] == "#":
                    break
                end += 1
            length = int(s[begin:end])
            result.append(s[end + 1 : end + 1 + length])
            begin = end + 1 + length
        return result