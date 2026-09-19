class Solution:

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [0] * 9
        cols = [0] * 9
        boxes = [0] * 9

        for r in range(9):
            for c in range(9):
                s = board[r][c]

                if s == '.':
                    continue
                
                bit = 1 << (ord(s) - ord('1'))

                b = (r // 3) * 3 + (c // 3)
                if (rows[r] & bit) or (cols[c] & bit) or (boxes[b] & bit):
                    return False
                rows[r] |= bit
                cols[c] |= bit
                boxes[b] |= bit

        return True