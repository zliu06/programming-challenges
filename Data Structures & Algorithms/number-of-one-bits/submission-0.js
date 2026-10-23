class Solution {
    /**
     * @param {number} n - a positive integer
     * @return {number}
     */
    hammingWeight(n) {
        let count = 0;
        n = Math.trunc(n);

        while (n !== 0) {
            count += n % 2;
            n = n >>> 1;
        }

        return count;
    }
}
