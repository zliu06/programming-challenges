class WordDictionary {

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean endOfWord = false;
    }

    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(Node curr, String word, int next) {
        if (next >= word.length()) {
            return curr.endOfWord;
        }
        
        char c = word.charAt(next);
        if (c == '.') {
            for (Character key: curr.children.keySet()) {
                if (dfs(curr.children.get(key), word, next+1)) {
                    return true;
                }
            }
            return false;
        } else {
            return curr.children.containsKey(c) 
                && dfs(curr.children.get(c), word, next+1);
        }
    }
}
