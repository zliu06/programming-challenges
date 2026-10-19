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
        List<Integer> startTimeList = new ArrayList<>();
        List<Integer> endTimeList = new ArrayList<>();
        for (Interval meeting: intervals) {
            startTimeList.add(meeting.start);
            endTimeList.add(meeting.end);
        }
        startTimeList.sort();
        endTimeList.sort();
        int s = 0;
        int e = 0;
        int concurrent = 0;
        int maxConcurrent = 0;
        while (s < startTimeList.size() && e < endTimeList.size()) {
            int start = startTimeList.get(s);
            int end = endTimeList.get(e);
            if (start < end) {
                concurrent++;
                if (concurrent > maxConcurrent) maxConcurrent = concurrent;
            } else if (end <= start) {
                concurrent--;
            }
        }
        return maxConcurrent;
    }
}
