class Solution {
    /**
     * @param {number} numCourses
     * @param {number[][]} prerequisites
     * @return {boolean}
     */
    canFinish(numCourses, prerequisites) {
        const graph = Array.from({ length: numCourses }, () => []);
        for (const [course, prereq] of prerequisites) {
            graph[course].push(prereq);
        }
        const status = new Array(numCourses);
        status.fill(0);
        for (let i = 0; i < numCourses; i++) {
            if (!this.dfs(i, graph, status)) return false;
        }
        return true;
    }

    dfs(course, graph, status) {
        if (status[course] == 1) {
            return false;
        }
        if (status[course] == 2) {
            return true;
        }
        status[course] = 1;
        for (const prereq of graph[course]) {
            if (!this.dfs(prereq, graph, status)) return false;
        }
        status[course] = 2;
        return true;
    }
}
