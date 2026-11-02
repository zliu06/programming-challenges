class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        unresolved = []
        results = [0] * len(temperatures)
        for i, t in enumerate(temperatures):
            while len(unresolved) > 0:
                if unresolved[-1][1] < t:
                    j, _ = unresolved.pop()
                    results[j] = i - j
                else:
                    break
            unresolved.append((i, t))
        return results
