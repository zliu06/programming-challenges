class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        Set<String> result = new HashSet<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, trie, result);
            }
        }
        return new ArrayList<>(result);
    }

    int[][] DIRECTIONS = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    void dfs(char[][] board, int row, int col, Trie trie, Set<String> result) {
        if (row < 0 || row >= board.length) return;
        if (col < 0 || col >= board[0].length) return;
        char ch = board[row][col];
        if (ch == '#') return;
        if (!trie.children.containsKey(ch)) {
            return;
        }
        Trie node = trie.children.get(ch);
        if (node.word != null) {
            result.add(node.word);
        }
        board[row][col]='#';
        for (int i=0; i<DIRECTIONS.length; i++) {
            int[] dir=DIRECTIONS[i];
            int r = row+dir[0];
            int c = col+dir[1];
            dfs(board, r, c, node, result);
        }
        board[row][col]=ch;
    }

    class Trie {
        HashMap<Character, Trie> children;
        String word;
        Trie() {
            children = new HashMap<>();
        }
    }

    Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word: words) {
            Trie node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Trie child = node.children.get(ch);
                if (child == null) {
                    child = new Trie();
                    node.children.put(ch, child);
                }
                node = child;
            }
            node.word = word;
        }
        return root;
    }
}
