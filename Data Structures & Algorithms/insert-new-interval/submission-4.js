class Solution {
    /**
     * @param {number[][]} intervals
     * @param {number[]} newInterval
     * @return {number[][]}
     */
    insert(intervals, newInterval) {
        const result = [];
        for (let i = 0; i < intervals.length; i++) {
            let interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                result.push(interval);
            } else if (newInterval[1] < interval[0]) {
                result.push(newInterval);
                for (let j = i; j < intervals.length; j++) {
                    result.push(intervals[j]);
                }
                return result;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0])
                newInterval[1] = Math.max(interval[1], newInterval[1])
            }
        }
        result.push(newInterval);
        return result;
    }
}
