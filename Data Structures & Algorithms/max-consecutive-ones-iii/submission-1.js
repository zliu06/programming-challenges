class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number}
     */
    longestOnes(nums, k) {
        let right = 0;
        let left = 0;
        let maxLen = 0;
        let maxFreq = 0;
        let freq0 = 0;
        let freq1 = 0;
        while (right < nums.length) {
            if (nums[right] === 1) {
                freq1 += 1;
            } else {
                freq0 += 1;
            }
            if (freq1 > maxFreq) {
                maxFreq = freq1;
            }
            console.log(`left=${left}, right=${right}, maxFreq=${maxFreq}`);
            let length = right - left + 1;
            while (length - maxFreq > k) {
                if (nums[left] === 1) {
                    freq1 -= 1;
                } else {
                    freq0 -= 1;
                }
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
