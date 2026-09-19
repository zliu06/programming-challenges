class Solution:
    def maxArea(self, heights: List[int]) -> int:
        i, j = 0, len(heights) - 1

        max_area = 0
        while i < j:
            h = min(heights[i], heights[j])
            d = j - i
            max_area = max(max_area, h * d)
            if h == heights[i]:
                i = i+1
            else:
                j = j-1

        return max_area       