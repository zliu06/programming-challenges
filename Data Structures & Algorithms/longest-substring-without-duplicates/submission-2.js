class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s) {
        let left = 0;
        let right = 0;
        let countMap = new Map();
        let maxLength = 0;
        while (right < s.length) {
            const char = s[right];
            countMap.set(char, (countMap.get(char) ?? 0) + 1);
            while (countMap.get(char) > 1 && left <= right) {
                countMap.set(s[left], countMap.get(s[left]) - 1);
                left += 1;
            }
            let length = right - left + 1;
            if (length > maxLength) {
                maxLength = length;
            }
            right += 1;
        }
        return maxLength;
    }
}
