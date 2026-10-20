/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

class Solution {
    /**
     * @param {Interval[]} intervals
     * @returns {number}
     */
    minMeetingRooms(intervals) {
        const startTimes = intervals.map(interval => interval.start);
        const endTimes = intervals.map(interval => interval.end);
        startTimes.sort((a, b) => a - b);
        endTimes.sort((a, b) => a - b);
        let i = 0;
        let j = 0;
        let count = 0;
        let maxCount = 0;
        while (i < startTimes.length && j < endTimes.length) {
            if (startTimes[i] < endTimes[j]) {
                count += 1;
                if (count > maxCount) maxCount = count;
                i++;
            } else {
                count -= 1;
                j++;
            }
        }
        return maxCount;
    }
}
