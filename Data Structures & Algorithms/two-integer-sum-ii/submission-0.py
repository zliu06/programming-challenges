class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i = 0
        j = len(numbers) - 1
        while True:
            sn = numbers[i] + numbers[j]
            if sn == target:
                return [i + 1, j + 1]
            elif sn > target:
                j -= 1
            else:
                i += 1
        return []