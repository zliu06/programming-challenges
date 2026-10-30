class Solution {
    /**
     * @param {string} s
     * @param {number} k
     * @return {number}
     */
    characterReplacement(s, k) {
        let left = 0;
        let right = 0;
        let maxLen = 0;
        let maxFreq = 0;
        let freqMap = new Map();
        while (right < s.length) {
            freqMap.set(s[right], (freqMap.get(s[right]) ?? 0) + 1);
            if (freqMap.get(s[right]) > maxFreq) {
                maxFreq = freqMap.get(s[right]);
            }
            let length = right - left + 1;
            while (length - maxFreq > k) {
                freqMap.set(s[left], freqMap.get(s[left]) - 1);
                left += 1;
                length = right - left + 1;
            }
            if (length > maxLen) {
                maxLen = length;
            }
            right += 1;
        }
        return maxLen;
    }
}
