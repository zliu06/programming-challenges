class Solution {
    public int rob(int[] nums) {
        int current = 0;
        int next = 0;
        for (int i = nums.length-1; i>=0; i--) {
            int tmp = current;
            current = Math.max(nums[i]+next, current);
            next = tmp;
        }
        return current;
    }
}
