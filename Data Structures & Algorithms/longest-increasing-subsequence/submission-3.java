class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = lowerBound(arr, 0, arr.size(), nums[i]);
            if (index < arr.size()) {
                arr.set(index, nums[i]);
            } else {
                arr.add(nums[i]);
            }
        }
        return arr.size();
    }

    public int lowerBound(List<Integer> nums, int start, int end, int target) {
        int left = start;
        int right = end;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums.get(mid) < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
