class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int maxFirstExcluded = rob(nums, 1, nums.length-1);
        int maxLastExcluded = rob(nums, 0, nums.length-2);
        return Math.max(maxFirstExcluded, maxLastExcluded);
    }

    int rob(int[] nums, int first, int last) {
        int current = 0;
        int next = 0;
        for (int i = last; i >= first; i--) {
            int tmp = current;
            current = Math.max(nums[i]+next, current);
            next = tmp;
        }
        return current;
    }
}
