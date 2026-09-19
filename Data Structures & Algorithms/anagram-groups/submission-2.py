class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)

        for txt in strs:
            group_key = ''.join(sorted(txt))
            groups[group_key].append(txt)
        
        return list(groups.values())

    def get_group_key(txt):
        frequency = [0] * 26
        for c in txt:
            frequency[ord(c) - ord('a')] += 1
        return tuple(frequency)