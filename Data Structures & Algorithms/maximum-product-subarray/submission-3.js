class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    maxProduct(nums) {
        let maxProduct = nums[0];
        let minProduct = nums[0];
        let largest = maxProduct;

        for (let i = 1; i < nums.length; i++) {
            const oldMax = maxProduct;
            const oldMin = minProduct;
            maxProduct = Math.max(nums[i], nums[i] * oldMax, nums[i] * oldMin);
            minProduct = Math.min(nums[i], nums[i] * oldMax, nums[i] * oldMin);

            if (maxProduct > largest) largest = maxProduct;
        }
        return largest;
    }
}
