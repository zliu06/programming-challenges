class MinStack:

    def __init__(self):
        self.main = []
        self.aux = []

    def push(self, val: int) -> None:
        self.main.append(val)
        if len(self.aux) > 0:
            self.aux.append(min(val, self.aux[-1]))
        else:
            self.aux.append(val)

    def pop(self) -> None:
        last = self.main.pop()
        self.aux.pop()
        return last

    def top(self) -> int:
        return self.main[-1]

    def getMin(self) -> int:
        return self.aux[-1]
        
