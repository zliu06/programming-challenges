class Solution {
    /**
     * @param {number} a
     * @param {number} b
     * @return {number}
     */
    getSum(a, b) {
        let carry;
        let xor;
        do {
            xor = a ^ b;
            carry = (a & b) << 1;
            a = xor;
            b = carry;
        } while (carry != 0);
        return xor;
    }
}
