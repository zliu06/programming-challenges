class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> solutions = new ArrayList<>();
        dfs(nums, 0, target, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    private void dfs(int[] nums, int index, int remaining, List<Integer> path, List<List<Integer>> solutions) {
        if (remaining == 0) {
            solutions.add(new ArrayList<>(path));
            return;
        }

        if (remaining < 0) {
            return;
        }

        if (index >= nums.length)
            return;

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i, remaining - nums[i], path, solutions);
            path.remove(path.size() - 1);
        }

    }
}
