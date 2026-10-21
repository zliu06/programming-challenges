class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    maxProduct(nums) {
        const maxProducts = nums.map((num) => num);
        const minProducts = nums.map((num) => num);
        for (let i = 1; i < nums.length; i++) {
            maxProducts[i] = Math.max(nums[i], nums[i] * maxProducts[i - 1], nums[i] * minProducts[i - 1]);
            minProducts[i] = Math.min(nums[i], nums[i] * maxProducts[i - 1], nums[i] * minProducts[i - 1]);
        }
        let largest = maxProducts[0];
        for (let i = 1; i < maxProducts.length; i++) {
            largest = Math.max(largest, maxProducts[i]);
        }
        return largest;
    }
}
