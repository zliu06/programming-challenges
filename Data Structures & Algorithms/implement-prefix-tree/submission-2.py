class PrefixTree:
    class Node:
        def __init__(self):
            self.children = {}
            self.end_of_word = False

    def __init__(self):
        self.root = self.Node()

    def insert(self, word: str) -> None:
        node = self.root
        for ch in word:
            if not ch in node.children:
                node.children[ch] = self.Node()
            node = node.children[ch]
        node.end_of_word = True

    def search(self, word: str) -> bool:
        node = self.root
        for ch in word:
            if not ch in node.children:
                return False
            node = node.children[ch]
        return node.end_of_word

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for ch in prefix:
            if not ch in node.children:
                return False
            node = node.children[ch]
        return True
