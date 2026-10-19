class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] left, int[] right) -> {
            return Integer.compare(left[0], right[0]);
        });
        int removed = 0;
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < last[1]) {
                if (intervals[i][1] > last[1]) {
                    // keep last, remove intervals[i]
                } else {
                    // keep intervals[i], replace last
                    last = intervals[i];
                }
                removed++;
            }
        }
        return removed;
    }
}
