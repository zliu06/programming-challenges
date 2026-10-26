class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        freq = {}
        for i in range(len(s)):
            ch = s[i]
            freq[ch] = freq.get(ch, 0) + 1
        freq2 = {}
        for i in range(len(t)):
            ch = t[i]
            freq2[ch] = freq2.get(ch, 0) + 1
        return freq == freq2