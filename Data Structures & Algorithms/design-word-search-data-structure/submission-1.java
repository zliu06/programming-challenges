class WordDictionary {

    static class TrieNode {
        boolean endOfWord = false;
        HashMap<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (Character c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.endOfWord;
        }
        Character c = word.charAt(index);
        if (c == '.') {
            for (Character key: node.children.keySet()) {
                if (dfs(node.children.get(key), word, index+1))
                    return true;
            }
            return false;
        } else {
            TrieNode child = node.children.get(c);
            if (child == null) {
                return false;
            }
            return dfs(child, word, index+1);
        }
    }
}
