class Solution {

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
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
            node.isWord = true;
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
        Set<String> exists = new HashSet<>();
        Set<Cell> visited = new HashSet<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(i, j, new ArrayList<>(), trie, exists, visited,board);
            }
        }

        return new ArrayList<>(exists);
    }

    void dfs(int row, int col, List<Character> path, TrieNode node, Set<String> exists, Set<Cell> visited, char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        if (row < 0 || col < 0 || row >= ROWS || col >= COLS) {
            return;
        }

        Character current = board[row][col];
        if (!node.children.containsKey(current)) {
            return;
        }

        TrieNode child = node.children.get(current);
        path.add(current);

        if (child.isWord) {
            String matched = path.stream().map(String::valueOf).collect(Collectors.joining());
            exists.add(matched);
        }

        visited.add(new Cell(row, col));
        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };

        for (int i = 0; i < dirs.length; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            if (visited.contains(new Cell(newRow, newCol))) continue;

            dfs(newRow, newCol, path, child, exists, visited, board);
        }

        visited.remove(new Cell(row, col));
        path.remove(path.size() - 1);
    }
}
