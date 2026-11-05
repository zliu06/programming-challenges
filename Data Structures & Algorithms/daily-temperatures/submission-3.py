class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        s = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures)):
            t = temperatures[i]
            while len(s) > 0:
                if s[-1][1] < t:
                    d, td = s.pop()
                    result[d] = i - d
                else:
                    break
            s.append((i, t))
        return result