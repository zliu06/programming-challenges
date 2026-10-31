class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
    minEatingSpeed(piles, h) {
        let maxPile = 0;
        for (let p of piles) {
            if (p > maxPile) {
                maxPile = p;
            }
        }
        let left = 1;
        let right = maxPile;
        let minK = Infinity;
        while (left <= right) {
            let mid = left + Math.floor((right - left) / 2);
            let d = 0;
            for (let p of piles) {
                d += Math.ceil(p / mid);
            }
            if (d <= h) {
                if (mid < minK) minK = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minK;
    }
}
