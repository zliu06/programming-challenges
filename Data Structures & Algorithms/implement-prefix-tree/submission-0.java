class PrefixTree {

    static class Node {
        Map<Character, Node> outedges = new HashMap<Character, Node>(); 
        boolean endOfWord = false;
    }

    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.outedges.containsKey(c)) {
                curr.outedges.put(c, new Node());
            }
            curr = curr.outedges.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.outedges.containsKey(c)) 
                return false;
            curr = curr.outedges.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!curr.outedges.containsKey(prefix.charAt(i)))
                return false;
            curr = curr.outedges.get(prefix.charAt(i));
        }
        return true;
    }
}
