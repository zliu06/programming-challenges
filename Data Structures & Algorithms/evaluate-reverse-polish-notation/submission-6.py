class Solution:

    @staticmethod
    def calculate(operator, operand1, operand2):
        if operator == "+":
            return operand1 + operand2
        elif operator == "-":
            return operand1 - operand2
        elif operator == "*":
            return operand1 * operand2
        elif operator == "/":
            return math.trunc(operand1 / operand2)
        else:
            raise Error("Unsupported operator")

    def evalRPN(self, tokens: List[str]) -> int:
        stack = list()
        for token in tokens:
            if token in ["+", "-", "*", "/"]:
                operand2 = stack.pop()
                operand1 = stack.pop()
                result = Solution.calculate(token, operand1, operand2)
                stack.append(result)
            else:
                stack.append(int(token))
        return stack.pop()