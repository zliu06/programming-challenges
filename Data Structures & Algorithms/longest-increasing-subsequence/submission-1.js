class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    lengthOfLIS(nums) {
        const dp = new Array();
        dp.push(nums[0]);
        for (let i = 1; i < nums.length; i++) {
            let index = this.lowerBound(dp, 0, dp.length, nums[i]);
            if (index < dp.length) dp[index] = nums[i];
            else dp.push(nums[i]);
        }
        return dp.length;
    }

    lowerBound(nums, left, right, target) {
        while (left < right) {
            let mid = left + Math.floor((right - left) / 2);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
