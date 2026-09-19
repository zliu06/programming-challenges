class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        Global g = new Global(nums, solutions);
        dfs(g, 0, target, new ArrayList<>());
        return solutions;
    }

    static record Global(int[] nums, List<List<Integer>> solutions) {}

    void dfs(Global g, int i, int target, List<Integer> used_numbers) {
        if (i >= g.nums.length) {
            return;
        }

        if (target == 0) {
            g.solutions.add(new ArrayList<>(used_numbers));
            return;
        }

        if (g.nums[i] <= target) {
            used_numbers.add(g.nums[i]);
            dfs(g, i, target - g.nums[i], used_numbers);
            used_numbers.remove(used_numbers.size() - 1);
        }

        dfs (g, i+1, target, used_numbers);
    }

}
