class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {boolean}
     */
    validTree(n, edges) {
        const graph = Array.from({length: n}, () => []);
        for (const [fro, to] of edges) {
            graph[fro].push(to);
            graph[to].push(fro);
        }

        const visited = new Array(n);
        visited.fill(0);
        
        const hasLoop = this.detectLoop(0, -1, visited, graph);
        if (hasLoop) {
            return false;
        }
        for (let i = 0; i < visited.length; i++) {
            if (visited[i] === 0) return false;
        }

        return true;
    }

    detectLoop(node, parent, visited, graph) {
        if (visited[node] !== 0) return true;
        visited[node] = 1;
        const neighbors = graph[node];
        for (let nbr of neighbors) {
            if (nbr === parent) continue;
            if (this.detectLoop(nbr, node, visited, graph)) {
                return true;
            }
        }
        return false;
    }
}
