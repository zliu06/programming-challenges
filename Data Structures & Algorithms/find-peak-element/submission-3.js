class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    findPeakElement(nums) {
        let left = 0;
        let right = nums.length - 1;
        while (left <= right) {
            let mid = left + Math.floor((right - left) / 2);
            let n = nums[mid];
            if (mid > 0 && n < nums[mid - 1]) {
                right = mid - 1;
            } else if (mid < nums.length - 1 && n < nums[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
    }
}
