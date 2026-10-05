class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            boolean canFinish = dfs(i, prerequisites, visited);
            if (!canFinish) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int course, int[][] prerequisites, int[] visited) {
        if (visited[course] == 1) {
            return false;
        } else if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;

        List<Integer> outedges = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == course) {
                outedges.add(prerequisites[i][1]);
            }
        }

        for (int i = 0; i < outedges.size(); i++) {
            int dependency = outedges.get(i);

            if (!dfs(dependency, prerequisites, visited)) {
                return false;
            }
        }

        visited[course] = 2;

        return true;
    }


}
