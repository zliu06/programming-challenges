class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices) {
        let i = 0;
        let j = 1;
        let min_buy = prices[i];
        let max_benefit = 0;
        while (j < prices.length) {
            while (i < j) {
                if (prices[i] < min_buy) {
                    min_buy = prices[i];
                }
                i += 1;
            }
            if ((prices[j] - min_buy) > max_benefit) {
                max_benefit = prices[j] - min_buy;
            }
            j += 1;
        } 
        return max_benefit;
    }
}
