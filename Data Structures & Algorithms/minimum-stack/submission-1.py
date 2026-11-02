class MinStack:

    def __init__(self):
        self.value_stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.value_stack.append(val);
        if len(self.min_stack) > 0:
            self.min_stack.append(min(self.min_stack[-1], val))
        else:
            self.min_stack.append(val)

    def pop(self) -> None:
        if len(self.value_stack):
            self.value_stack.pop()
            self.min_stack.pop()

    def top(self) -> int:
        return self.value_stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
        
