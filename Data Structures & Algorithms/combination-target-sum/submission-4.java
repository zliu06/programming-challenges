class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        DFS dfs = new DFS();
        dfs.traverse(nums, 0, new ArrayList<>(), target);
        return dfs.solutions;
    }

    class DFS {
        List<List<Integer>> solutions = new ArrayList<>();

        public void traverse(int[] nums, int first, List<Integer> path, int target) {
            if (target == 0) {
                solutions.add(new ArrayList<>(path));
            } else if (target < 0) {
                return;
            }
            if (nums.length == 0) {
                return;
            }
            for (int i = first; i < nums.length; i++) {
                path.add(nums[i]);
                traverse(nums, i, path, target - nums[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
