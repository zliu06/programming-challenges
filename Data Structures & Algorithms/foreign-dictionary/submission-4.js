class Solution {
    /**
     * @param {string[]} words
     * @returns {string}
     */
    foreignDictionary(words) {
        const graph = new Map();
        const inDegree = new Map();
        for (let word of words) {
            for (let c of word) {
                if (!graph.has(c)) {
                    graph.set(c, new Set());
                    inDegree.set(c, 0);
                }
            }
        }
        for (let i = 0; i < words.length - 1; i++) {
            let j = i + 1;
            // compare word i and word j
            const left = words[i];
            const right = words[j];
            let k = 0;
            const len = Math.min(left.length, right.length);
            for (; k < len; k++) {
                if (left[k] != right[k]) {
                    if (!graph.get(left[k]).has(right[k])) {
                        graph.get(left[k]).add(right[k]);
                        inDegree.set(right[k], inDegree.get(right[k]) + 1);
                    }
                    break;
                }
            }
            if (k == len) {
                if (left.length > right.length) {
                    return "";
                }
            }
        }

        const result = [];
        const queue = [];
        let head = 0;
        for (let [char, degree] of inDegree) {
            if (degree === 0) {
                queue.push(char);
            }
        }

        while (head < queue.length) {
            let nextChar = queue[head++];
            result.push(nextChar);

            let neighbors = graph.get(nextChar);
            for (let nbr of neighbors) {
                inDegree.set(nbr, inDegree.get(nbr) - 1);
                if (inDegree.get(nbr) === 0) {
                    queue.push(nbr);
                }
            }
        }

        if (result.length === inDegree.size) {
            return result.join("");
        } else {
            return "";
        }
    }
}
