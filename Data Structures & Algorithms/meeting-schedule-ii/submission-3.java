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
    public int minMeetingRooms(List<Interval> intervals) {
        int[] startTimes = new int[intervals.size()];
        int[] endTimes = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            Interval meeting = intervals.get(i);
            startTimes[i] = meeting.start;
            endTimes[i] = meeting.end;
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int i=0;
        int j=0;
        int concurrent = 0;
        while (i < startTimes.length && j < endTimes.length) {
            if (startTimes[i] < endTimes[j]) {
                concurrent++;
                i++;
            } else {
                concurrent--;
                j++;
            }
        }
        return concurrent;
    }
}
