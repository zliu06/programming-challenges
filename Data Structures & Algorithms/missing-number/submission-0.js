class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    missingNumber(nums) {
        const upperBound = nums.length + 1;
        let res = 0;
        for (let i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        for (let i = 0; i < upperBound; i++) {
            res = res ^ i;
        }
        return res;
    }
}
