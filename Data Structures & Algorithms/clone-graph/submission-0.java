/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return new DFS().traverse(node);
    }

    class DFS {
        HashMap<Node, Node> oldToNew = new HashMap<>();

        Node traverse(Node node) {
            if (oldToNew.containsKey(node)) {
                return oldToNew.get(node);
            }

            Node clone = new Node(node.val);
            oldToNew.put(node, clone);

            for (Node nbr: node.neighbors) {
                Node nbrClone = traverse(nbr);
                clone.neighbors.add(nbrClone);
            }

            return clone;

        } 
    }
}