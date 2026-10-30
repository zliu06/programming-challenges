class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        right = 0
        freq_map = {}
        max_freq = 0
        max_length = 1
        while right < len(s):
            #print(f"left is {left}, and right is {right}")
            freq_map[s[right]] = freq_map.get(s[right], 0) + 1
            #print(f"freq of {s[right]} is {freq_map[s[right]]}")
            if freq_map[s[right]] > max_freq:
                max_freq = freq_map[s[right]]
                #print(f"max_freq := {max_freq}")
            length = right - left + 1
            #print(f"length is {length}")
            if length - max_freq <= k:
                if right - left + 1 > max_length:
                    max_length = right - left + 1
                    #print(f"max_length is {max_length}")
            else:
                while length - max_freq > k:
                    freq_map[s[left]] = freq_map[s[left]] - 1
                    left += 1
                    length = right - left + 1
                #print(f"left := {left}")
            right += 1
        return max_length
