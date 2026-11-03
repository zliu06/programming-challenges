class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l = r = 0
        q = collections.deque()
        result = []
        while r < len(nums):
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            q.append(r)
            if (r - l + 1) > k:
                l += 1
            if l > q[0]:
                q.popleft()
            if r >= (k-1):
                result.append(nums[q[0]])
            r += 1
        return result