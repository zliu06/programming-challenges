class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l = r = 0
        q = collections.deque()
        result = []
        for r in range(len(nums)):
            while len(q) > 0:
                if nums[q[-1]] < nums[r]:
                    q.pop()
                else:
                    break
            q.append(r)
            if r - l + 1 > k:
                l += 1
                if q[0] < l:
                    q.popleft()
            if r >= k - 1:
                result.append(nums[q[0]])
        return result
