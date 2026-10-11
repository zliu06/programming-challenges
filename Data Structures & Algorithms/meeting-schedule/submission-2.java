/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        Collections.sort(intervals, (int1, int2) -> {
            return int1.start - int2.start;
        });
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start < last.end) return false;
            last = current;
        }
        return true;
    }
}
