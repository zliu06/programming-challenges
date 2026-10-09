class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] left, int[] right) -> {
            return left[0] - right[0];
        });
        int lastEnd = intervals[0][1];
        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] < lastEnd) {
                lastEnd = Math.min(lastEnd, current[1]);
                removed += 1;
            } else {
                lastEnd = current[1];
            }
        }
        return removed;
    }
}
