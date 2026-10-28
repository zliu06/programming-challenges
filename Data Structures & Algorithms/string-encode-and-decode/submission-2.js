class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs) {
        const result = [];
        for (let i = 0; i < strs.length; i++) {
            const word = strs[i];
            const length = word.length;
            result.push(`${length}#${word}`);
        }
        return result.join("");
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str) {
        let head = 0;
        const result = [];
        while (head < str.length) {
            let j = head;
            while (str[j] != "#") {
                j += 1;
            }
            let length = Number(str.slice(head, j));
            let word = str.slice(j + 1, j + 1 + length);
            result.push(word);
            head = j + 1 + length;
        }
        return result;
    }
}
