class Solution {

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    static int[][] DIRECTIONS = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                node = node.children.computeIfAbsent(c, (ch) -> new TrieNode());
            }
            node.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = buildTrie(words);
        Set<String> matched = new HashSet<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, trie, matched);
            }
        }
        return new ArrayList<>(matched);
    }

    void dfs(char[][] board, int row, int col, TrieNode node, Set<String> matched) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        Character ch = board[row][col];
        if (!node.children.containsKey(ch)) {
            return;
        }
        if (board[row][col] == '#') return;        
        node = node.children.get(ch);
        board[row][col] = '#';
        if (node.word != null) matched.add(node.word);
        for (int d = 0; d < DIRECTIONS.length; d++) {
            int[] dir = DIRECTIONS[d];
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(board, r, c, node, matched);
        }
        board[row][col] = ch;
    }
}
