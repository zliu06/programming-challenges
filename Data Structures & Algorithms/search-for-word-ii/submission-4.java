class Solution {

    int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (Character c: word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLS = board[0].length;

        TrieNode trie = buildTrie(words);
        Set<String> matched = new HashSet<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(board, i, j, trie, matched);
            }
        }

        return new ArrayList<>(matched);
    }

    void dfs(char[][] board, int row, int col, TrieNode node, Set<String> matched) {
        int ROWS = board.length;
        int COLS = board[0].length;

        if (row < 0 || col < 0 || row >= ROWS || col >= COLS) {
            return;
        }

        if (board[row][col] == '#') {
            return;
        }

        Character current = board[row][col];
        if (!node.children.containsKey(current)) {
            return;
        }

        TrieNode child = node.children.get(current);
        if (child.word != null) {
            matched.add(child.word);
        }
        board[row][col] = '#';
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];
            dfs(board, newRow, newCol, child, matched);
        }

        board[row][col] = current;
    }
}
