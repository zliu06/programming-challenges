class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        stack = []
        cars = sorted(zip(position, speed), reverse=True)
        for pos, spd in cars:
            time = (target - pos) / spd
            if stack and stack[-1] >= time:
                pass
            else:
                stack.append(time)
        return len(stack)