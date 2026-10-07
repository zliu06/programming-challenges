class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visitStatus = new int[numCourses];
        List<List<Integer>> dependencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            dependencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            dependencyList.get(from).add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            boolean canFinish = dfs(i, visitStatus, dependencyList);
            if (!canFinish) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int course, int[] visitStatus, List<List<Integer>> dependencyList) {
        if (visitStatus[course] == 1) {
            return false;
        }
        else if (visitStatus[course] == 2) {
            return true;
        }

        visitStatus[course] = 1;
        List<Integer> dependencies = dependencyList.get(course);
        for (int dep : dependencies) {
            boolean canFinish = dfs(dep, visitStatus, dependencyList);
            if (!canFinish) {
                return false;
            }
        }
        visitStatus[course] = 2;
        return true;
    }
}
