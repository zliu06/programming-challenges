class Solution:

    def generateParenthesis(self, n: int) -> List[str]:
        backtracking = Solution.Backtracking(n)
        backtracking.generate(0, 0)
        return backtracking.results

        
    class Backtracking:
        def __init__(self, n):
            self.n = n
            self.prefix = []
            self.results = []
        
        def generate(self, open_count, close_count):
            if len(self.prefix) == self.n * 2:
                self.results.append(''.join(self.prefix))
                return
            if open_count < self.n:
                self.prefix.append('(')
                self.generate(open_count + 1, close_count)
                self.prefix.pop()

            if open_count > close_count:
                self.prefix.append(')')
                self.generate(open_count, close_count + 1)
                self.prefix.pop()


            
            

