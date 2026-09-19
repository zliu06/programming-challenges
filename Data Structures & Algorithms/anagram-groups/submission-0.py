class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)

        for txt in strs:
            ordered_txt = ''.join(sorted(txt))
            groups[ordered_txt].append(txt)
        
        return [groups[key] for key in groups.keys()]