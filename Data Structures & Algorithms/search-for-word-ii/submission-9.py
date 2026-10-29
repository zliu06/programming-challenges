class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        class Node:
            def __init__(self):
                self.children = {}
                self.word = None

        def buildTrie(words):
            root = Node()
            for word in words:
                node = root
                for ch in word:
                    if not ch in node.children:
                        node.children[ch] = Node()
                    node = node.children[ch]
                node.word = word
            return root

        def backtrack(board, r, c, node, match_group):
            if r < 0 or r >= len(board):
                return
            if c < 0 or c >= len(board[0]):
                return
            if board[r][c] == "#":
                return
            if not board[r][c] in node.children:
                return
            ch = board[r][c]
            child_node = node.children[ch]
            if child_node.word is not None:
                match_group.add(child_node.word)
            board[r][c] = "#"
            backtrack(board, r + 1, c, child_node, match_group)
            backtrack(board, r - 1, c, child_node, match_group)
            backtrack(board, r, c + 1, child_node, match_group)
            backtrack(board, r, c - 1, child_node, match_group)
            board[r][c] = ch
        
        match_group = set()
        root = buildTrie(words)
        for r in range(len(board)):
            for c in range(len(board[0])):
                backtrack(board, r, c, root, match_group)
        return list(match_group)

