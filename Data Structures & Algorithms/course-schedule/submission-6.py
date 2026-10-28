class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjList = [[] for _ in range(numCourses)]
        for dependency in prerequisites:
            fro, to = dependency
            adjList[fro].append(to)
        status = [0] * numCourses

        def backtrack(course) -> bool:
            nonlocal status
            if status[course] == 1:
                return False
            if status[course] == 2:
                return True
            status[course] = 1
            for prereq in adjList[course]:
                if not backtrack(prereq):
                    return False
            status[course] = 2
            return True
        
        for i in range(numCourses):
            if not backtrack(i):
                return False
        return True