class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] prereq: prerequisites) {
            adjacencyList.get(prereq[0]).add(prereq[1]);
        }
        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjacencyList, status)) return false;
        }
        return true;
    }

    boolean dfs(int course, List<List<Integer>> adjacencyList, int[] status) {
        if (status[course] != 0) {
            if (status[course] == 1) return false;
            else if (status[course] == 2) return true;
        }
        status[course] = 1;
        for (int prereq: adjacencyList.get(course)) {
            if (!dfs(prereq, adjacencyList, status)) return false;
        }
        status[course] = 2;
        return true;
    }
}
