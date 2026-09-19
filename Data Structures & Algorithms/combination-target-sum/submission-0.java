class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = solve(nums, target, 1);
        return out == null ? new ArrayList<>(): out;
    }

    public List<List<Integer>> solve(int nums[], int target, int lower_threshold) {

        if (target == 0) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        if (target < 0) {
            return null;
        }

        boolean has_solution = false;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= lower_threshold) {
                List<List<Integer>> out = solve(nums, target - nums[i], nums[i]);
                if (out != null) {
                    for (List<Integer> one:out) {
                        one.add(nums[i]);
                        result.add(one);
                        has_solution = true;
                    }
                }
            }
        }

        if (has_solution) {
            return result;
        }
        return null;
    }
}
