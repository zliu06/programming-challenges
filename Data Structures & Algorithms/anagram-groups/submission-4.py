class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = {}
        for word in strs:
            key = [0] * 26
            for ch in word:
                key[ord(ch) - ord("a")] += 1
            groups.setdefault(tuple(key), []).append(word)
        return list(groups.values())