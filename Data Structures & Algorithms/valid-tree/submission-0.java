class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            out.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            out.get(edge[0]).add(edge[1]);
            out.get(edge[1]).add(edge[0]);
        }
        int[] status = new int[n];
        boolean hasCycle = dfs(0, -1, out, status);
        if (hasCycle) return false;
        for (int i = 0; i < n; i++) {
            if (status[i] != 1) return false;
        }
        return true;
    }

    boolean dfs(int current, int last, List<List<Integer>> out, int[] status) {
        if (status[current] == 1) return true;
        status[current] = 1;
        List<Integer> neighbors = out.get(current);
        for (Integer nbr: neighbors) {
            if (nbr == last) continue;
            boolean hasCycle = dfs(nbr, current, out, status);
            if (hasCycle) return true;
        }
        return false;
    }
}
