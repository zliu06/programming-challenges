class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        waiting = []
        result = [0] * len(temperatures)
        for i, t in enumerate(temperatures):
            while waiting and temperatures[waiting[-1]] < t:
                index = waiting.pop()
                result[index] = i - index
            waiting.append(i)
        return result