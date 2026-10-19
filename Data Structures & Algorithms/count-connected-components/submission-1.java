class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] status = new int[n];
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            out.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            out.get(edges[i][0]).add(edges[i][1]);
            out.get(edges[i][1]).add(edges[i][0]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (status[i] == 0) {
                dfs(i, status, out);
                result++;
            }
        }
        return result;
    }

    void dfs(int node, int[] status, List<List<Integer>> out) {
        if (status[node] == 1) return;
        status[node] = 1;
        List<Integer> neighbors = out.get(node);
        for (int nbr: neighbors) {
            dfs(nbr, status, out);
        }
    }
}
