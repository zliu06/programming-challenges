class Solution:

    @staticmethod
    def check_and_mark(counter, num):
        if counter[num] > 0:
            return True
        counter[num] = 1
        return False

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for n in range(9):
            v = n % 3
            h = n // 3

            r = h * 3
            c = v * 3

            counter = [0] * 10
            for ir in range(3):
                for ic in range(3):
                    s = board[r+ir][c+ic]
                    if s.isdigit():
                        if Solution.check_and_mark(counter, int(s)):
                            return False
        
        for h in range(9):
            counter = [0] * 10
            for s in board[h]:
                if s.isdigit():
                    if Solution.check_and_mark(counter, int(s)):
                        return False

        for v in range(9):
            counter = [0] * 10
            for h in range(9):
                s = board[h][v]
                if s.isdigit():
                    if Solution.check_and_mark(counter, int(s)):
                        return False

        return True
