class MedianFinder:
    def __init__(self):
        self.lh = []
        self.rh = []

    def addNum(self, num: int) -> None:
        med = self.findMedian()
        if med is None or num >= med:
            heapq.heappush(self.rh, num)
        else:
            heapq.heappush(self.lh, -num)
        right_size = len(self.rh)
        left_size = len(self.lh)
        if right_size > left_size + 1:
            m = heapq.heappop(self.rh)
            heapq.heappush(self.lh, -m)
        elif left_size > right_size + 1:
            m = -(heapq.heappop(self.lh))
            heapq.heappush(self.rh, m)

    def findMedian(self) -> float:
        ls = len(self.lh)
        rs = len(self.rh)
        if ls == rs:
            if ls == 0:
                return None
            l = -self.lh[0]
            r = self.rh[0]
            return (l + r) / 2
        elif ls > rs:
            return -self.lh[0]
        else:
            return self.rh[0]