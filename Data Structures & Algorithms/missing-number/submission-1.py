from itertools import chain
from functools import reduce

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        return reduce(lambda acc, num: acc ^ num, chain(range(len(nums)+1), nums), 0)
        
