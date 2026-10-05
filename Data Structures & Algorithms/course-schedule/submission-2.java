class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];

        List<List<Integer>> dependency = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            dependency.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            dependency.get(from).add(to);
        }

        for (int i = 0; i < numCourses; i++) {
            boolean canFinish = dfs(i, dependency, visited);
            if (!canFinish) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int course, List<List<Integer>> dependency, int[] visited) {
        if (visited[course] == 1) {
            return false;
        } else if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;

        List<Integer> outedges = dependency.get(course);

        for (int i = 0; i < outedges.size(); i++) {
            int dependsOn = outedges.get(i);

            if (!dfs(dependsOn, dependency, visited)) {
                return false;
            }
        }

        visited[course] = 2;

        return true;
    }


}
