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
            insert(root, word, 0);
        }
        return root;
    }

    void insert(TrieNode node, String word, int index) {
        if (index >= word.length()) {
            node.word = word;
            return;
        }

        Character c = word.charAt(index);
        if (!node.children.containsKey(c)) {
            TrieNode child = new TrieNode();
            node.children.put(c, child);
        }

        insert(node.children.get(c), word, index+1);
    }

    record Cell(int row, int col) {}

    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLS = board[0].length;

        TrieNode trie = buildTrie(words);
        Set<String> matched = new HashSet<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matched.addAll(dfs(board, i, j, trie));
            }
        }

        return new ArrayList<>(matched);
    }

    Set<String> dfs(char[][] board, int row, int col, TrieNode node) {
        int ROWS = board.length;
        int COLS = board[0].length;

        if (row < 0 || col < 0 || row >= ROWS || col >= COLS) {
            return Collections.emptySet();
        }

        if (board[row][col] == '#') {
            return Collections.emptySet();
        }

        Character current = board[row][col];
        if (!node.children.containsKey(current)) {
            return Collections.emptySet();
        }

        Set<String> matched = new HashSet<>();
        TrieNode child = node.children.get(current);
        if (child.word != null) {
            matched.add(child.word);
        }
        board[row][col] = '#';
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];
            matched.addAll(dfs(board, newRow, newCol, child));
        }

        board[row][col] = current;
        return matched;
    }
}
