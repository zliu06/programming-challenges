class WordDictionary:
    class Node:
        def __init__(self):
            self.children = {}
            self.end_of_word = False

    def __init__(self):
        self.root = self.Node()

    def addWord(self, word: str) -> None:
        node = self.root

        for ch in word:
            if not ch in node.children:
                node.children[ch] = self.Node()
            node = node.children[ch]

        node.end_of_word = True

    def search(self, word: str) -> bool:

        def recursive_search(node, word, index) -> bool:
            if index == len(word):
                return node.end_of_word
            ch = word[index]
            if ch == ".":
                for child in node.children.values():
                    if recursive_search(child, word, index + 1):
                        return True
                else:
                    return False
            else:
                if ch in node.children:
                    return recursive_search(node.children[ch], word, index + 1)
                return False

        return recursive_search(self.root, word, 0);